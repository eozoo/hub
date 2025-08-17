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

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuxueli/shanhuiming
 */
public class ClientRouteRound implements ClientRouter {

    private static final ConcurrentMap<Integer, AtomicInteger> ROUTE_COUNT_EACH_JOB = new ConcurrentHashMap<>();

    private static long CACHE_VALID_TIME = 0;

    @Override
    public String route(ClientService clientService, TriggerRequest triggerParam, List<String> addressList) {
        return addressList.get(count(triggerParam.getTriggerId())%addressList.size());
    }

    private static int count(int jobId) {
        // cache clear
        if (System.currentTimeMillis() > CACHE_VALID_TIME) {
            ROUTE_COUNT_EACH_JOB.clear();
            CACHE_VALID_TIME = System.currentTimeMillis() + 1000*60*60*24;
        }

        AtomicInteger count = ROUTE_COUNT_EACH_JOB.get(jobId);
        if (count == null || count.get() > 1000000) {
            // 初始化时主动Random一次，缓解首次压力
            count = new AtomicInteger(new Random().nextInt(100));
        } else {
            // count++
            count.addAndGet(1);
        }
        ROUTE_COUNT_EACH_JOB.put(jobId, count);
        return count.get();
    }
}
