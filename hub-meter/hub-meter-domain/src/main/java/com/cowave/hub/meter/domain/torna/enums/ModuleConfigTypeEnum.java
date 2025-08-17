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
 * 模块类型
 *
 * @author tanghc
 */
public enum ModuleConfigTypeEnum {
    /**
     * 通用配置
     */
    COMMON((byte) 0, (byte) 0),
    /**
     * 公共请求头
     */
    GLOBAL_HEADERS((byte) 1, ParamStyleEnum.HEADER.getStyle()),
    /**
     * 调试host
     */
    DEBUG_HOST((byte) 2, (byte)0),
    /**
     * 公共请求参数
     */
    GLOBAL_PARAMS((byte) 3, ParamStyleEnum.REQUEST.getStyle()),
    /**
     * 公共返回参数
     */
    GLOBAL_RETURNS((byte) 4, ParamStyleEnum.RESPONSE.getStyle()),
    /**
     * 公共错误码
     */
    GLOBAL_ERROR_CODES((byte) 5, ParamStyleEnum.ERROR_CODE.getStyle()),
    ;

    private final byte type;
    private final byte style;

    ModuleConfigTypeEnum(byte type, byte style) {
        this.type = type;
        this.style = style;
    }

    public byte getType() {
        return type;
    }

    public byte getStyle() {
        return style;
    }
}
