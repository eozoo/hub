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

import com.cowave.zoo.tools.EnumVal;
import lombok.Getter;

/**
 * @author xuxueli/shanhuiming
 */
@Getter
public enum JobScheduleType implements EnumVal<Void> {

    /**
     * Cron表达式
     */
    CRON,

    /**
     * 固定间隔，相对开始时间
     */
    FIX_RATE,

    /**
     * 固定频率，相对结束时间
     */
    FIX_DELAY
}
