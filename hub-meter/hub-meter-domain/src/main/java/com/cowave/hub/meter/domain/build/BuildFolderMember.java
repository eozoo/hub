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
import com.cowave.hub.meter.domain.constants.FolderRole;
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
public class BuildFolderMember implements AccessInfoSetter {

    /**
     * 目录id
     */
    private Integer folderId;

    /**
     * 成员编码
     */
    private String userCode;

    /**
     * 成员名称
     */
    private String userName;

    /**
     * 成员角色
     */
    private FolderRole userRole;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
