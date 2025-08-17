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

import java.util.Date;

/**
 * @author xuxueli/shanhuiming
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TriggerResponse {

    /**
     * 任务id
     */
    private int triggerId;

    /**
     * 日志id
     */
    private long logId;

    /**
     * 执行状态
     */
    private int handleStatus;

    /**
     * 执行开始时间
     */
    private Date handleTime;

    /**
     * 执行耗时
     */
    private long handleCost;

    /**
     * 失败原因
     */
    private String handleMsg;
}
