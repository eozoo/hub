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
package com.cowave.hub.job.infra.route;

import com.cowave.hub.job.infra.route.impl.*;
import com.cowave.zoo.tools.EnumVal;
import lombok.Getter;

/**
 * @author xuxueli/shanhuiming
 */
@Getter
public enum JobRouteStrategy implements EnumVal<Void> {

    /**
     * 第一个
     */
    FIRST(new ClientRouteFirst()),

    /**
     * 最后一个
     */
    LAST(new ClientRouteLast()),

    /**
     * 轮询
     */
    ROUND(new ClientRouteRound()),

    /**
     * 随机
     */
    RANDOM(new ClientRouteRandom()),

    /**
     * HASH散列
     */
    CONSISTENT_HASH(new ClientRouteConsistentHash()),

    /**
     * 最不经常使用
     */
    LEAST_FREQUENTLY_USED(new ClientRouteLFU()),

    /**
     * 最久未使用
     */
    LEAST_RECENTLY_USED(new ClientRouteLRU()),

    /**
     * 故障转移
     */
    FAIL_OVER(new ClientRouteFailover()),

    /**
     * 忙碌转移
     */
    BUSY_OVER(new ClientRouteBusyOver()),

    /**
     * 分片广播
     */
    SHARDING_BROADCAST(null);

    JobRouteStrategy(ClientRouter router) {
        this.router = router;
    }

    private final ClientRouter router;
}
