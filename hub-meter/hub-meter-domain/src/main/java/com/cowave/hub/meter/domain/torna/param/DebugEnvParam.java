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
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author tanghc
 */
@Getter
@Setter
public class DebugEnvParam {

    @ApiDocField(description = "环境名称", maxLength = "50", required = true, example = "测试环境")
    @NotBlank(message = "调试环境名称不能为空")
    private String name;

    @ApiDocField(description = "调试路径",  maxLength = "100", required = true, example = "http://10.1.30.165:2222")
    @NotBlank(message = "调试路径不能为空")
    private String url;
}
