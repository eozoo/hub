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
 * @author tanghc
 */
public enum DocTypeEnum {
    HTTP((byte) 0),
    DUBBO((byte) 1),
    /** 富文本 */
    CUSTOM((byte) 2),
    /** markdown */
    MARKDOWN((byte) 3),
    ;

    DocTypeEnum(byte type) {
        this.type = type;
    }

    public static DocTypeEnum of(Byte type) {
        for (DocTypeEnum value : DocTypeEnum.values()) {
            if (Objects.equals(value.getType(), type)) {
                return value;
            }
        }
        return HTTP;
    }

    public static boolean isTextType(Byte type) {
        return Objects.equals(CUSTOM.type, type) || Objects.equals(MARKDOWN.type, type);
    }

    private final byte type;

    public byte getType() {
        return type;
    }
}
