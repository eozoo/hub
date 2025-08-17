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
package com.cowave.hub.job.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author xuxueli/shanhuiming
 */
@Data
public class JobTriggerLog {

	/**
	 * 日志id
	 */
	private Long id;

	/**
	 * 任务id
	 */
	private int triggerId;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 调度类型
	 */
	private String triggerType;

	/**
	 * 状态
	 */
	private int triggerStatus;

	/**
	 * 调度时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date triggerTime;

	/**
	 * 执行器名称
	 */
	private String handlerName;

	/**
	 * 执行器参数
	 */
	private String handlerParam;

	/**
	 * 执行器地址
	 */
	private String clientAddress;

	/**
	 * 分片参数
	 */
	private String shardingParam;

	/**
	 * 执行时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date handleTime;

	/**
	 * 执行耗时
	 */
	private Long handleCost;

	/**
	 * 失败原因
	 */
	private String failMsg;
}
