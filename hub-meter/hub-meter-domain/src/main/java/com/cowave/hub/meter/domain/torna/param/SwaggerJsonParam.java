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

/**
 * @author thc
 */
@Data
public class SwaggerJsonParam {

    @NotBlank(message = "推送人不能为空")
    @Length(max = 20, message = "推送人长度不能超过20")
    @ApiDocField(description = "推送人", example = "Jim")
    private String author;

    @NotBlank(message = "swagger json不能为空")
    @ApiDocField(description = "swagger json")
    private String json;
}
