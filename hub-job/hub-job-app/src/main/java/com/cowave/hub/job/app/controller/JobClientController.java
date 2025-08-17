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
import com.cowave.hub.job.domain.client.ClientRegistry;
import com.cowave.hub.job.domain.client.TriggerResponse;
import com.cowave.hub.job.service.JobClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户端
 *
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class JobClientController {

    private final JobClientService jobClientService;

    /**
     * 注册
     */
    @PostMapping("/registry")
    public Response<Void> registry(@Validated @RequestBody ClientRegistry clientRegistry) throws Exception {
        return Response.success(() -> jobClientService.registry(clientRegistry));
    }

    /**
     * 注销
     */
    @PostMapping("/unregistry")
    public Response<Void> unRegistry(@Validated @RequestBody ClientRegistry clientRegistry) throws Exception {
        return Response.success(() -> jobClientService.unRegistry(clientRegistry));
    }

    /**
     * 回调
     */
    @PostMapping("/callback")
    public Response<Void> callback(@Validated @RequestBody List<TriggerResponse> list) throws Exception {
        return Response.success(() -> jobClientService.callback(list));
    }
}
