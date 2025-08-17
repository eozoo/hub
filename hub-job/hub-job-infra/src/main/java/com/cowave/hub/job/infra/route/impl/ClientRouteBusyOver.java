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
package com.cowave.hub.job.infra.route.impl;

import com.cowave.zoo.http.client.constants.HttpCode;
import com.cowave.zoo.http.client.response.Response;
import com.cowave.hub.job.domain.client.IdleCheck;
import com.cowave.hub.job.domain.client.TriggerRequest;
import com.cowave.hub.job.infra.route.ClientRouter;
import com.cowave.hub.job.infra.ClientService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * @author xuxueli/shanhuiming
 */
@Slf4j
public class ClientRouteBusyOver implements ClientRouter {

    @Override
    public String route(ClientService clientService, TriggerRequest triggerParam, List<String> addressList) {
        for (String address : addressList) {
            try {
                Response<String> response = clientService.idle(address, new IdleCheck(triggerParam.getTriggerId()));
                if (Objects.equals(response.getCode(), HttpCode.SUCCESS.getCode())) {
                    return address;
                }
            } catch (Exception e) {
                log.error("", e);
            }
        }
        return null;
    }
}
