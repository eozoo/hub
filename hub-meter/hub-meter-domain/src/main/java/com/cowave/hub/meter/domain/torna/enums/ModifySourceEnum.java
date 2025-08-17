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
package com.cowave.hub.meter.domain.torna.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 来源方式，0：推送，1：表单编辑, 2:文本编辑
 * @author thc
 */
@Getter
@AllArgsConstructor
public enum ModifySourceEnum {
    PUSH((byte)0),
    FORM((byte)1),
    TEXT((byte)2)
    ;

    private final byte source;

}
