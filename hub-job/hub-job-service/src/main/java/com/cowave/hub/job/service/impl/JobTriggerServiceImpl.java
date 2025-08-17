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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.zoo.framework.access.Access;
import com.cowave.hub.job.domain.JobTrigger;
import com.cowave.hub.job.domain.request.JobTriggerQuery;
import com.cowave.hub.job.infra.dao.JobTriggerDao;
import com.cowave.hub.job.infra.dao.JobTriggerLogDao;
import com.cowave.hub.job.infra.schedule.ScheduleTrigger;
import com.cowave.hub.job.service.JobTriggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cowave.hub.job.domain.enums.JobTriggerType.MANUAL;

/**
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@Transactional
@Service
public class JobTriggerServiceImpl implements JobTriggerService {
    private final ScheduleTrigger scheduleTrigger;
    private final JobTriggerDao jobTriggerDao;
    private final JobTriggerLogDao jobTriggerLogDao;

    @Override
    public Page<JobTrigger> pageList(JobTriggerQuery query) {
        return jobTriggerDao.pageList(query);
    }

    @Override
    public void create(JobTrigger jobTrigger) {
        jobTrigger.setCreateBy(Access.userAccount());
        jobTriggerDao.save(jobTrigger);
    }

    @Override
    public void delete(List<Integer> jobIds) {
        jobTriggerDao.removeByIds(jobIds);
        jobTriggerLogDao.removeByTriggerIds(jobIds);
    }

    @Override
    public void exec(Integer id) {
        scheduleTrigger.trigger(id, MANUAL, null, null);
    }

    @Override
    public void switchStatus(Integer id, Integer status) {
        jobTriggerDao.switchStatus(id, status);
    }
}
