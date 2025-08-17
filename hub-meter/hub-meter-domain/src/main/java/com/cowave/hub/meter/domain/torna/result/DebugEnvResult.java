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

import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tanghc
 */
@Setter
@Getter
public class DebugEnvResult {

    /** 配置key*/
    @ApiDocField(description = "环境名称", example = "测试环境")
    private String configKey;

    /** 配置值 */
    @ApiDocField(description = "调试路径", example = "http://10.0.1.31:8080")
    private String configValue;

}
