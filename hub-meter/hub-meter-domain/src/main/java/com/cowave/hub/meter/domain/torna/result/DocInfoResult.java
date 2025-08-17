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

/**
 * @author tanghc
 */
@Data
public class DocInfoResult {
    @ApiDocField(description = "文档id", dataType = DataType.STRING, maxLength = "12", example = "9VXEyXvg")
    private Long id;

    /**
     * 文档名称
     */
    @ApiDocField(description = "文档名称", maxLength = "50", example = "获取商品信息")
    private String name;

    /**
     * 文档概述
     */
    @ApiDocField(description = "文档概述", maxLength = "200", example = "根据ID查询商品信息")
    private String description;

    /**
     * 版本号
     */
    @ApiDocField(description = "版本号", maxLength = "10", example = "1.0")
    private String version;

    /**
     * 访问URL
     */
    @ApiDocField(description = "url", maxLength = "100", example = "/goods/get")
    private String url;

    /**
     * http方法
     */
    @ApiDocField(description = "http方法", maxLength = "50", example = "GET")
    private String httpMethod;

    /**
     * contentType
     */
    @ApiDocField(description = "contentType", maxLength = "50", example = "application/json")
    private String contentType;

    /** 文档类型,0:http,1:dubbo,2:富文本,3:Markdown */
    @ApiDocField(description = "0:http,1:dubbo,2:富文本,3:Markdown", maxLength = "50", example = "")
    private Byte type;

    /**
     * 是否是分类，0：不是，1：是
     */
    @ApiDocField(description = "是否是分类，0：不是，1：是", example = "0")
    private Byte isFolder;

    /**
     * 父节点
     */
    @ApiDocField(description = "父节点", dataType = DataType.STRING, example = "Br2jqzG7")
    private Long parentId;

    /**
     * 是否显示
     */
    @ApiDocField(description = "是否显示，1：显示，0：不显示", example = "1")
    private Byte isShow;

}
