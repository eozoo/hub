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
import com.cowave.hub.job.domain.JobTriggerLog;
import com.cowave.hub.job.domain.request.JobTriggerLogQuery;
import com.cowave.hub.job.infra.dao.JobTriggerLogDao;
import com.cowave.hub.job.service.JobTriggerLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@Transactional
@Service
public class JobTriggerLogServiceImpl implements JobTriggerLogService {
    private final JobTriggerLogDao jobTriggerLogDao;

    @Override
    public Page<JobTriggerLog> pageList(JobTriggerLogQuery query) {
       return jobTriggerLogDao.pageList(query);
    }
}
