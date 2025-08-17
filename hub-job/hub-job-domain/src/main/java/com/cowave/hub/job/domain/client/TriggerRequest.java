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

import lombok.Data;


/**
 * @author xuxueli/shanhuiming
 */
@Data
public class TriggerRequest {

    /**
     * 任务id
     */
    private int triggerId;

    /**
     * 日志id
     */
    private long logId;

    /**
     * 执行器名称
     */
    private String handlerName;

    /**
     * 执行参数
     */
    private String handlerParams;

    /**
     * 阻塞策略
     */
    private String blockStrategy;

    /**
     * 超时时间
     */
    private int timeOut;

    /**
     * 任务类型
     */
    private String glueType;

    /**
     * 脚本内容
     */
    private String glueSource;

    /**
     * 脚本更新时间
     */
    private long glueUpdateTime;

    /**
     * 分片参数
     */
    private int broadIndex;

    /**
     * 分片参数
     */
    private int broadTotal;
}
