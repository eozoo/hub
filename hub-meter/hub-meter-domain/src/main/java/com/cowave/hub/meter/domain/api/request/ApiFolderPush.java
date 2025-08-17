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

import com.cowave.hub.meter.domain.torna.param.DebugEnvParam;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author tanghc
 */
@Data
public class ApiFolderPush {

    /**
     * 调试环境
     */
    private List<DebugEnvParam> debugEnvs;

    /**
     * api列表
     */
    @NotEmpty(message = "文档内容不能为空")
    private List<ApiPush> apis;

    /**
     * 推送人
     */
    private String author;

    /**
     * 公共错误码
     */
    private List<ApiCodePush> commonErrorCodes;

    /**
     * 是否替换文档，1：替换，0：不替换
     */
    private Byte isReplace = 1;

    /**
     * 是否覆盖文档，1：覆盖，0：不覆盖
     */
    private Byte isOverride = 0;
}
