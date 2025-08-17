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
 * 表名：compose_doc
 * 备注：文档引用
 *
 * @author tanghc
 */
@Data
public class ComposeDoc {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** doc_info.id, 数据库字段：doc_id */
    private Long docId;

    /** compose_project.id, 数据库字段：project_id */
    private Long projectId;

    /** 是否文件夹, 数据库字段：is_folder */
    private Byte isFolder;

    /** 文件夹名称, 数据库字段：folder_name */
    private String folderName;

    /**  数据库字段：parent_id */
    private Long parentId;

    /** 文档来源, 数据库字段：origin */
    private String origin;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /** 创建人, 数据库字段：creator */
    private String creator;

    /**  数据库字段：order_index */
    private Integer orderIndex;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
