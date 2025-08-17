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

/**
 * 登录用户信息
 * @author tanghc
 */
public interface User {

    /**
     * 用户id
     * @return
     */
    Long getUserId();

    /**
     * 操作方式
     * @return
     */
    byte getOperationModel();

    /**
     * 是否超级管理员
     * @return
     */
    boolean isSuperAdmin();

    /**
     * 昵称
     * @return
     */
    String getNickname();

    Byte getStatus();

    String getToken();
}
