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

import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author tanghc
 */
@Data
public class EnumInfoCreateParam {

    /** 枚举名称, 数据库字段：name */
    @NotBlank(message = "名称不能为空")
    @Length(max = 100, message = "名称长度不能超过100")
    @ApiDocField(description = "字典分类名称", required = true, example = "支付枚举")
    private String name;

    /** 枚举说明, 数据库字段：description */
    @Length(max = 100, message = "描述长度不能超过100")
    @ApiDocField(description = "字典分类描述", example = "支付状态")
    private String description;

    @NotEmpty(message = "枚举项不能为空")
    @ApiDocField(description = "枚举项", required = true, elementClass = EnumItemCreateParam.class)
    private List<EnumItemCreateParam> items;
}
