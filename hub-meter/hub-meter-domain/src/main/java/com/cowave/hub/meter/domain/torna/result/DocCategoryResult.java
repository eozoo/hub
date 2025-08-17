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
package com.cowave.hub.meter.domain.torna.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.cowave.hub.meter.domain.torna.support.IdCodec;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class DocCategoryResult {
    @ApiDocField(description = "分类id", maxLength = "12", example = "9VXEyXvg")
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long id;

    /** 文档名称, 数据库字段：name */
    @ApiDocField(description = "分类名称", maxLength = "50", example = "商品分类")
    private String name;
}
