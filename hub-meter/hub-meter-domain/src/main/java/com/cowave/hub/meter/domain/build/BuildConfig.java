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
package com.cowave.hub.meter.domain.build;

import com.cowave.zoo.framework.access.security.AccessInfoSetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shanhuiming
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuildConfig implements AccessInfoSetter {

    /**
     * 构建id
     */
    private Integer buildId;

    /**
     * 目录id
     */
    private Integer folderId;

    /**
     * 构建名称
     */
    private String buildName;

    /**
     * 上次构建状态
     */
    private Integer lastStatus;

    /**
     * 上次构建耗时
     */
    private Long lastCost;

    /**
     * 上次构建成功时间
     */
    private Date lastTimeSuccess;

    /**
     * 上次构建失败时间
     */
    private Date lastTimeFailure;

    /**
     * 仓库地址
     */
    private String repoUrl;

    /**
     * 仓库类型
     */
    private String repoType;

    /**
     * 仓库协议
     */
    private String repoProtocol;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
