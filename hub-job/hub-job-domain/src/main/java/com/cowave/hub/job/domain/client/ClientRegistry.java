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
package com.cowave.hub.job.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

/**
 * @author xuxueli/shanhuiming
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRegistry {

    /**
     * 客户端名称
     */
    @NotBlank(message = "clientName can't be empty")
    private String clientName;

    /**
     * 客户端地址
     */
    @NotBlank(message = "clientAddress can't be empty")
    private String clientAddress;

    /**
     * 执行器列表
     */
    private Collection<String> handlerList;
}
