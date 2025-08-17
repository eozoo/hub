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
package com.cowave.hub.job.client.handler;

import com.cowave.hub.job.client.TriggerContext;
import com.cowave.hub.job.domain.enums.JobTriggerStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author xuxueli/shanhuiming
 */
@Slf4j
@RequiredArgsConstructor
public class MethodJobHandler implements JobHandler {

    private final Object target;

    private final Method method;

    private final Method initMethod;

    private final Method destroyMethod;

    @Override
    public void execute() {
        long startTime = System.currentTimeMillis();
        TriggerContext.get().setHandleTime(new Date());
        Class<?>[] paramTypes = method.getParameterTypes();
        try {
            if (paramTypes.length > 0) {
                method.invoke(target, new Object[paramTypes.length]);
            } else {
                method.invoke(target);
            }
            TriggerContext.get().setHandleStatus(JobTriggerStatus.EXEC_SUCCESS.getStatus());
        } catch (Exception e) {
            log.error("", e);
            TriggerContext.get().setHandleStatus(JobTriggerStatus.EXEC_FAIL.getStatus());
            TriggerContext.get().setHandleMsg(e.getMessage());
        }
        TriggerContext.get().setHandleCost(System.currentTimeMillis() - startTime);
    }

    @Override
    public void init() throws Exception {
        if(initMethod != null) {
            initMethod.invoke(target);
        }
    }

    @Override
    public void destroy() throws Exception {
        if(destroyMethod != null) {
            destroyMethod.invoke(target);
        }
    }
}
