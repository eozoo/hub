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
package com.cowave.hub.meter.domain.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.cowave.hub.meter.domain.torna.enums.OperationMode;
import com.cowave.hub.meter.domain.torna.bean.Booleans;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author tanghc
 */
@Data
public class ApiCodePush {

    /**
     * 错误码
     */
    @JSONField(name = "code")
    @Length(max = 50, message = "参数名不能超过50")
    @NotBlank(message = "参数名不能为空")
    private String name;

    /**
     * 错误描述
     */
    @JSONField(name = "msg")
    @Length(max = 256, message = "描述长度不能超过256")
    @NotBlank(message = "错误描述不能为空")
    private String description;

    /**
     * 解决方案
     */
    @JSONField(name = "solution")
    @Length(max = 100, message = "描述长度不能超过100")
    private String example = "";

    private Byte createMode = OperationMode.OPEN.getType();

    private Byte modifyMode = OperationMode.OPEN.getType();

    private Byte isDeleted = Booleans.FALSE;

}
