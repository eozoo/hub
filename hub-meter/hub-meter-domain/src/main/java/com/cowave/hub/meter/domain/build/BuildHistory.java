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

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class BuildHistory {

    /**
     * 构建id
     */
    @TableId(type = IdType.AUTO)
    private Long historyId;

    /**
     * 任务id
     */
    private Integer buildId;

    /**
     * 构建序列
     */
    private Long buildIndex;

    /**
     * 构建目录
     */
    private String buildHome;

    /**
     * 构建分支
     */
    private String buildBranch;

    /**
     * 构建标签
     */
    private String buildTag;

    /**
     * 构建版本
     */
    private String buildVersion;

    /**
     * 构建耗时
     */
    private long buildCost;

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
