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

/**
 * @author tanghc
 */
@Data
public class DubboParam {

    @ApiDocField(description = "服务名称", example = "com.xx.doc.dubbo.DubboInterface")
    private String interfaceName;

    @ApiDocField(description = "author", example = "yu 2020/7/29.")
    private String author;

    @ApiDocField(description = "版本号", example = "1.0")
    private String version;

    @ApiDocField(description = "协议", example = "dubbo")
    private String protocol;

    @ApiDocField(description = "dependency", example = "<dependency>...</dependency>")
    private String dependency;
}
