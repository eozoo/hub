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
package com.cowave.hub.job.domain.enums;

import lombok.Getter;

/**
 * @author xuxueli/shanhuiming
 */
@Getter
public enum JobTriggerStatus {

    /**
     * 初始化
     */
    INIT(0),

    /**
     * 路由失败
     */
    ROUTE_FAIL(10),

    /**
     * 调用异常
     */
    HTTP_FAIL(20),

    /**
     * 调用失败
     */
    REMOTE_FAIL(30),

    /**
     * 调用成功
     */
    REMOTE_SUCCESS(40),

    /**
     * 执行超时
     */
    EXEC_OVERTIME(50),

    /**
     * 执行失败
     */
    EXEC_FAIL(60),

    /**
     * 执行成功
     */
    EXEC_SUCCESS(70);

    JobTriggerStatus(int status) {
        this.status = status;
    }

    private final int status;
}
