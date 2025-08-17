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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author xuxueli/shanhuiming
 */
@Slf4j
@RequiredArgsConstructor
public class GlueJobHandler implements JobHandler {

    private final JobHandler jobHandler;

    @Getter
    private final long glueUpdatetime;

    @Override
    public void execute() {
        long startTime = System.currentTimeMillis();
        TriggerContext.get().setHandleTime(new Date());
        try {
            jobHandler.execute();
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
        this.jobHandler.init();
    }

    @Override
    public void destroy() throws Exception {
        this.jobHandler.destroy();
    }
}
