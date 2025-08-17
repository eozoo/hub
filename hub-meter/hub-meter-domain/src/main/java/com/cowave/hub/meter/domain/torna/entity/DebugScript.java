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
 * 表名：debug_script
 *
 * @author tanghc
 */
@Data
public class DebugScript {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 名称, 数据库字段：name */
    private String name;

    /** 描述, 数据库字段：description */
    private String description;

    /** 脚本内容, 数据库字段：content */
    private String content;

    /** 类型，0：pre，1：after, 数据库字段：type */
    private Byte type;

    /** 作用域，0：当前文档，1：当前应用，2：当前项目, 数据库字段：scope */
    private Byte scope;

    /** 关联id, 数据库字段：ref_id */
    private Long refId;

    /** 创建人昵称, 数据库字段：creator_name */
    private String creatorName;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /** 是否启用 */
    private Byte enabled;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
