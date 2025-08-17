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
package com.cowave.hub.meter.domain.torna.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * 表名：compose_additional_page
 * 备注：聚合文档附加页
 *
 * @author tanghc
 */
@Data
public class ComposeAdditionalPage {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** compose_project.id, 数据库字段：project_id */
    private Long projectId;

    /** 文档标题, 数据库字段：title */
    private String title;

    /** 文档内容, 数据库字段：content */
    private String content;

    /** 排序值, 数据库字段：order_index */
    private Integer orderIndex;

    /** 1:启用，0：禁用, 数据库字段：status */
    private Byte status;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
