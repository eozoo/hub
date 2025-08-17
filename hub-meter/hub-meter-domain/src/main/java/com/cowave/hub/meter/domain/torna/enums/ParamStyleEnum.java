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

import java.util.Objects;

/**
 * 0：path, 1：header， 2：body参数，3：返回参数，4：错误码, 5：query参数
 * @author tanghc
 */
public enum ParamStyleEnum {
    PATH((byte)0),
    HEADER((byte)1),
    QUERY((byte)5),
    REQUEST((byte)2),
    RESPONSE((byte)3),
    ERROR_CODE((byte)4),
    ;

    private final byte style;

    public static ParamStyleEnum of(Byte value) {
        for (ParamStyleEnum paramStyleEnum : ParamStyleEnum.values()) {
            if (Objects.equals(paramStyleEnum.style, value)) {
                return paramStyleEnum;
            }
        }
        return QUERY;
    }

    ParamStyleEnum(byte style) {
        this.style = style;
    }

    public byte getStyle() {
        return style;
    }
}
