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
package com.cowave.hub.meter.domain.torna.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.cowave.hub.meter.domain.torna.support.IdCodec;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class EnumItemDTO {
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long id;

    /** enum_info.id, 数据库字段：enum_id */
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long enumId;

    /** 名称，字面值, 数据库字段：name */
    private String name;

    /** 类型, 数据库字段：type */
    private String type;

    /** 枚举值, 数据库字段：value */
    private String value;

    /** 枚举描述, 数据库字段：description */
    private String description;
}
