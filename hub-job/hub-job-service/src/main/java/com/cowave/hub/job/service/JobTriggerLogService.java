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
package com.cowave.hub.job.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.hub.job.domain.JobTriggerLog;
import com.cowave.hub.job.domain.request.JobTriggerLogQuery;

/**
 * @author xuxueli/shanhuiming
 */
public interface JobTriggerLogService {

    Page<JobTriggerLog> pageList(JobTriggerLogQuery query);
}
