/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.cowave.hub.job.infra.route.impl;

import com.cowave.hub.job.domain.client.TriggerRequest;
import com.cowave.hub.job.infra.route.ClientRouter;
import com.cowave.hub.job.infra.ClientService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 最近最久未使用，时间
 * @author xuxueli/shanhuiming
 */
public class ClientRouteLRU implements ClientRouter {

    private static final ConcurrentMap<Integer, LinkedHashMap<String, String>> JOB_LRU_MAP = new ConcurrentHashMap<>();

    private static long CACHE_VALID_TIME = 0;

    @Override
    public String route(ClientService clientService, TriggerRequest triggerParam, List<String> addressList) {
        return route(triggerParam.getTriggerId(), addressList);
    }

    public String route(int jobId, List<String> addressList) {
        // cache clear
        if (System.currentTimeMillis() > CACHE_VALID_TIME) {
            JOB_LRU_MAP.clear();
            CACHE_VALID_TIME = System.currentTimeMillis() + 1000*60*60*24;
        }

        // init lru
        LinkedHashMap<String, String> lruItem = JOB_LRU_MAP.get(jobId);
        if (lruItem == null) {
            /*
             * LinkedHashMap
             *      a、accessOrder：true=访问顺序排序（get/put时排序）；false=插入顺序排期；
             *      b、removeEldestEntry：新增元素时将会调用，返回true时会删除最老元素；可封装LinkedHashMap并重写该方法，比如定义最大容量，超出是返回true即可实现固定长度的LRU算法；
             */
            lruItem = new LinkedHashMap<>(16, 0.75f, true);
            JOB_LRU_MAP.putIfAbsent(jobId, lruItem);
        }

        // put new
        for (String address: addressList) {
            if (!lruItem.containsKey(address)) {
                lruItem.put(address, address);
            }
        }
        // remove old
        List<String> delKeys = new ArrayList<>();
        for (String existKey: lruItem.keySet()) {
            if (!addressList.contains(existKey)) {
                delKeys.add(existKey);
            }
        }
        if (!delKeys.isEmpty()) {
            for (String delKey: delKeys) {
                lruItem.remove(delKey);
            }
        }

        // load
        String eldestKey = lruItem.entrySet().iterator().next().getKey();
        return lruItem.get(eldestKey);
    }
}
