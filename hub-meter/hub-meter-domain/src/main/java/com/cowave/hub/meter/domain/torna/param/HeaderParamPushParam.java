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
package com.cowave.hub.meter.domain.torna.param;

import com.cowave.hub.meter.domain.torna.enums.OperationMode;
import com.cowave.hub.meter.domain.torna.bean.Booleans;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tanghc
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HeaderParamPushParam {

    /** 字段名称, 数据库字段：name */
    @ApiDocField(description = "header名称", required = true, example = "token")
    @NotBlank(message = "header名称不能为空")
    @Length(max = 50)
    private String name;

    /** 字段类型, 数据库字段：type */
    @ApiDocField(description = "字段类型", required = true, example = "string/array/object")
    @NotBlank(message = "字段类型不能为空")
    @Length(max = 50, message = "字段类型不能超过50")
    private String type;

    /** 是否必须，1：是，0：否, 数据库字段：required */
    @ApiDocField(description = "是否必须，1：是，0：否", required = true, example = "1")
    @NotNull(message = "是否必须不能为空")
    private Byte required;

    /** 示例值, 数据库字段：example */
    @ApiDocField(description = "示例值", example = "iphone12")
    @Length(max = 100, message = "示例值长度不能超过100")
    private String example;

    /** 描述, 数据库字段：description */
    @ApiDocField(description = "描述", example = "商品名称描述", maxLength = "256")
    @Length(max = 256, message = "描述长度不能超过256")
    private String description;

    @ApiDocField(description = "参数对应的枚举，如果参数是枚举，可以顺便把枚举信息填进来")
    private EnumInfoCreateParam enumInfo;

    @Builder.Default
    private Byte createMode = OperationMode.OPEN.getType();

    @Builder.Default
    private Byte modifyMode = OperationMode.OPEN.getType();

    @Builder.Default
    private Byte isDeleted = Booleans.FALSE;

}
