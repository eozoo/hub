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
package com.cowave.hub.job.service.impl;

import com.cowave.zoo.tools.Collections;
import com.cowave.hub.job.domain.JobClient;
import com.cowave.hub.job.domain.JobClientHandler;
import com.cowave.hub.job.domain.enums.JobTriggerStatus;
import com.cowave.hub.job.domain.client.ClientRegistry;
import com.cowave.hub.job.domain.client.TriggerResponse;
import com.cowave.hub.job.infra.dao.JobClientDao;
import com.cowave.hub.job.infra.dao.JobClientHandlerDao;
import com.cowave.hub.job.infra.dao.JobTriggerDao;
import com.cowave.hub.job.infra.dao.JobTriggerLogDao;
import com.cowave.hub.job.service.JobClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@Transactional
@Service
public class JobClientServiceImpl implements JobClientService {
    private final JobClientDao jobClientDao;
    private final JobTriggerDao jobTriggerDao;
    private final JobTriggerLogDao jobTriggerLogDao;
    private final JobClientHandlerDao jobClientHandlerDao;

    @Override
    public void registry(ClientRegistry clientRegistry) {
        JobClient jobClient = new JobClient(clientRegistry);
        Integer clientId = jobClientDao.registry(jobClient);
        jobClientHandlerDao.removeByClientId(clientId);
        List<JobClientHandler> handlerList = Collections.copyToList(
                clientRegistry.getHandlerList(), h -> new JobClientHandler(clientId, h));
        jobClientHandlerDao.saveBatch(handlerList);
    }

    @Override
    public void unRegistry(ClientRegistry clientRegistry) {
        JobClient jobClient = new JobClient(clientRegistry);
        Integer clientId = jobClientDao.unRegistry(jobClient);
        jobClientHandlerDao.removeByClientId(clientId);
    }

    @Override
    public void callback(List<TriggerResponse> list) {
        for(TriggerResponse triggerResponse : list){
            jobTriggerLogDao.completeTriggerLog(triggerResponse);
            if(JobTriggerStatus.EXEC_SUCCESS.getStatus() ==  triggerResponse.getHandleStatus()){
                jobTriggerDao.increaseTriggerSuccessTimes(triggerResponse.getTriggerId());
            }
        }
    }
}
