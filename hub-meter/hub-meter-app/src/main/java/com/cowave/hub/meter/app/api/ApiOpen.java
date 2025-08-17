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
package com.cowave.hub.meter.app.api;

import com.cowave.zoo.http.client.asserts.Asserts;
import com.cowave.hub.meter.domain.api.request.ApiFolderPush;
import com.cowave.hub.meter.service.api.ApiPushService;
import com.gitee.easyopen.ApiContext;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author shanhuiming
 */
@Slf4j
@ApiService
@RequiredArgsConstructor
public class ApiOpen {

    private final ApiPushService apiPushService;

    @Api(name = "doc.push")
    public void push(@RequestBody ApiFolderPush folderPush) {
        String apiToken = ApiContext.getAccessToken();
        Asserts.notBlank(apiToken, "api token can't be empty");
        apiPushService.push(apiToken, folderPush);
    }
}
