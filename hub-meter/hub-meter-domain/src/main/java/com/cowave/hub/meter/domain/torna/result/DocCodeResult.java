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
import com.gitee.easyopen.doc.DataType;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Data;

/**
 * @author tanghc
 */
@Data
public class DocCodeResult {
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    @ApiDocField(description = "参数id", example = "asdf", dataType = DataType.STRING)
    private Long id;

    /** 字段名称 */
    @ApiDocField(name = "code", description = "参数名", required = true, example = "10001")
    @JSONField(name = "code")
    private String name;

    /** 错误描述, 数据库字段：description */
    @ApiDocField(name = "msg", description = "错误描述", example = "token错误")
    @JSONField(name = "msg")
    private String description;

    /** 解决方案 */
    @ApiDocField(name = "solution", description = "解决方案", example = "请填写token")
    @JSONField(name = "solution")
    private String example;

}
