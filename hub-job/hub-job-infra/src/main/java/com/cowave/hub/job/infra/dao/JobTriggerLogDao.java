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
package com.cowave.hub.job.infra.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.zoo.framework.access.Access;
import com.cowave.hub.job.domain.JobTriggerLog;
import com.cowave.hub.job.domain.client.TriggerResponse;
import com.cowave.hub.job.domain.request.JobTriggerLogQuery;
import com.cowave.hub.job.infra.dao.mapper.JobTriggerLogMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuxueli/shanhuiming
 */
@Repository
public class JobTriggerLogDao extends ServiceImpl<JobTriggerLogMapper, JobTriggerLog> {

    /**
     * 日志分页查询
     */
    public Page<JobTriggerLog> pageList(JobTriggerLogQuery query) {
        return lambdaQuery().orderByDesc(JobTriggerLog::getTriggerTime).page(Access.page());
    }

    /**
     * 删除任务日志
     */
    public void removeByTriggerIds(List<Integer> jobIds){
        lambdaUpdate().in(JobTriggerLog::getTriggerId, jobIds).remove();
    }

    /**
     * 任务回调更新日志
     */
    public void completeTriggerLog(TriggerResponse triggerResponse) {
        lambdaUpdate()
                .eq(JobTriggerLog::getTriggerId, triggerResponse.getTriggerId())
                .eq(JobTriggerLog::getId, triggerResponse.getLogId())
                .set(JobTriggerLog::getTriggerStatus, triggerResponse.getHandleStatus())
                .set(JobTriggerLog::getHandleTime, triggerResponse.getHandleTime())
                .set(JobTriggerLog::getHandleCost, triggerResponse.getHandleCost())
                .set(JobTriggerLog::getFailMsg, triggerResponse.getHandleMsg())
                .update();
    }
}
