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
package com.cowave.hub.meter.domain.torna.bean;

import com.cowave.hub.meter.domain.torna.enums.OperationMode;
import com.cowave.hub.meter.domain.torna.enums.UserStatusEnum;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class ApiUser implements User {

    private Long id = 99999L;

    private String nickname = "OpenAPI";

    @Override
    public Long getUserId() {
        return id;
    }

    @Override
    public byte getOperationModel() {
        return OperationMode.OPEN.getType();
    }

    @Override
    public boolean isSuperAdmin() {
        return false;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public Byte getStatus() {
        return UserStatusEnum.ENABLE.getStatus();
    }

    @Override
    public String getToken() {
        return "";
    }
}
