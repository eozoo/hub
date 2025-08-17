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
package com.cowave.hub.job.app.controller;

import com.cowave.zoo.http.client.response.Response;
import com.cowave.hub.job.domain.JobTriggerLog;
import com.cowave.hub.job.domain.request.JobTriggerLogQuery;
import com.cowave.hub.job.service.JobTriggerLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务日志
 *
 * @author xuxueli/shanhuiming
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trigger/log")
public class JobTriggerLogController {

    private final JobTriggerLogService jobTriggerLogService;

    /**
     * 列表
     */
    @GetMapping
    public Response<Response.Page<JobTriggerLog>> list(JobTriggerLogQuery query) {
        return Response.page(jobTriggerLogService.pageList(query));
    }
}
