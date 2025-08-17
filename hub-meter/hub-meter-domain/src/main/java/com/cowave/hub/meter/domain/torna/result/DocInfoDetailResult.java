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
import java.util.List;

/**
 * @author tanghc
 */
@Data
public class DocInfoDetailResult {
    @ApiDocField(description = "文档id", example = "je24ozLJ", required = true)
    private Long id;

    /**
     * 文档名称 name
     */
    @ApiDocField(description = "文档名称", required = true, maxLength = "50", example = "获取商品信息")
    private String name;

    /**
     * 文档概述 description
     */
    @ApiDocField(description = "文档概述", maxLength = "200", example = "获取商品信息")
    private String description;

    /**
     * 访问URL url
     */
    @ApiDocField(description = "url", maxLength = "100", example = "/goods/get")
    private String url;

    /**
     * 版本号
     */
    private String version = "";

    /**
     * http方法 http_method
     */
    @ApiDocField(description = "http方法", maxLength = "50", example = "GET")
    private String httpMethod;

    /**
     * contentType content_type
     */
    @ApiDocField(description = "contentType", maxLength = "50", example = "application/json")
    private String contentType;

    /**
     * 是否是分类，0：不是，1：是 is_folder
     */
    @ApiDocField(description = "是否是分类，0：不是，1：是", example = "1")
    private Byte isFolder;

    /**
     * 父节点 parent_id
     */

    @ApiDocField(description = "父节点, 没有填空字符串", dataType = DataType.STRING, example = "")
    private Long parentId;

    /**
     * 是否显示 is_show
     */
    @ApiDocField(description = "是否显示，1：显示，0：不显示", example = "1")
    private Byte isShow;

    /**
     * 创建人
     */
    @ApiDocField(description = "创建人", maxLength = "50", example = "jim")
    private String creatorName;

    /**
     * 修改人
     */
    @ApiDocField(description = "修改人", maxLength = "50", example = "jim")
    private String modifierName;

    /**
     * 数据库字段：gmt_create
     */
    @ApiDocField(description = "创建时间")
    private LocalDateTime gmtCreate;

    /**
     * 数据库字段：gmt_modified
     */
    @ApiDocField(description = "最后修改时间")
    private LocalDateTime gmtModified;

    @ApiDocField(description = "调试环境", elementClass = DebugEnvResult.class)
    private List<DebugEnvResult> debugEnvs;

    @ApiDocField(description = "请求头", elementClass = DocHeaderResult.class)
    private List<DocHeaderResult> headerParams;

    @ApiDocField(description = "请求参数", elementClass = DocParamResult.class)
    private List<DocParamResult> requestParams;

    @ApiDocField(description = "返回参数", elementClass = DocParamResult.class)
    private List<DocParamResult> responseParams;

    @ApiDocField(description = "错误码", elementClass = DocCodeResult.class)
    private List<DocCodeResult> errorCodeParams;
}
