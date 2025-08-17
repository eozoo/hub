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

/**
 * @author tanghc
 */
public enum UserSubscribeTypeEnum {
    /**
     * 订阅文档
     */
    DOC((byte)1),
    /**
     * 订阅项目
     */
    PROJECT((byte)2),
    /**
     * 推送文档
     */
    PUSH_DOC((byte) 3),
    /**
     * 订阅版本
     */
    RELEASE((byte) 4),
    ;

    private final byte type;

    UserSubscribeTypeEnum(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }
}
