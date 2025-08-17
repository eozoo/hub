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

import com.gitee.easyopen.doc.DataType;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tanghc
 */
@Data
public class DocParamResult {

    @ApiDocField(description = "参数id", example = "asdf", maxLength = "12", dataType = DataType.STRING)
    private Long id;

    /** 字段名称, 数据库字段：name */
    @ApiDocField(description = "参数名", required = true, maxLength = "50", example = "goodsName")
    private String name;

    /** 字段类型, 数据库字段：type */
    @ApiDocField(description = "字段类型", required = true, maxLength = "50", example = "string")
    private String type;

    /** 是否必须，1：是，0：否, 数据库字段：required */
    @ApiDocField(description = "是否必须，1：是，0：否", required = true, example = "1")
    private Byte required;

    /** 最大长度, 数据库字段：max_length */
    @ApiDocField(description = "最大长度", maxLength = "50", example = "128")
    private String maxLength;

    /** 示例值, 数据库字段：example */
    @ApiDocField(description = "示例值", maxLength = "100", example = "iphone12")
    private String example;

    /** 描述, 数据库字段：description */
    @ApiDocField(description = "描述", maxLength = "200", example = "商品名称描述")
    private String description;


    @ApiDocField(description = "字典id", maxLength = "12", example = "L42GEXWG")
    private Long enumId;

    /** doc_info.id, 数据库字段：doc_id */

    @ApiDocField(description = "文档id", maxLength = "12", dataType = DataType.STRING)
    private Long docId;

    /** 父节点, 数据库字段：parent_id */

    @ApiDocField(description = "父节点, 没有填空字符串", maxLength = "12", dataType = DataType.STRING)
    private Long parentId;

    /** 创建人 */
    @ApiDocField(description = "创建人", maxLength = "50")
    private String creatorName;

    /** 修改人 */
    @ApiDocField(description = "最后修改人", maxLength = "50")
    private String modifierName;

    /**  数据库字段：gmt_create */
    @ApiDocField(description = "创建时间")
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    @ApiDocField(description = "最后修改时间")
    private LocalDateTime gmtModified;

}
