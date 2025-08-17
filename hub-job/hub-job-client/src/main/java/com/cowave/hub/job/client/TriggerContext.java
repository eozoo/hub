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
package com.cowave.hub.job.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@Data
public class TriggerContext {

    private static final InheritableThreadLocal<TriggerContext> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    public static void set(TriggerContext triggerContext){
        CONTEXT_HOLDER.set(triggerContext);
    }

    public static TriggerContext get(){
        return CONTEXT_HOLDER.get();
    }

    private final long jobId;

    private final String jobParam;

    private final int shardIndex;

    private final int shardTotal;

    private Date handleTime;

    private int handleStatus;

    private long handleCost;

    private String handleMsg;
}
