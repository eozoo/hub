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
public enum JobBlockStrategy implements EnumVal<Void> {

    /**
     * 单机串行
     */
    SERIAL_EXECUTION,

    /**
     * 丢弃后续任务
     */
    DISCARD_LATER,

    /**
     * 覆盖之前任务
     */
    COVER_EARLY
}
