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
 * 表名：project_user
 * 备注：项目用户关系表
 *
 * @author tanghc
 */
@Data
public class ProjectUser {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** project.id, 数据库字段：project_id */
    private Long projectId;

    /** user_info.id, 数据库字段：user_id */
    private Long userId;

    /** 角色，guest：访客，dev：开发者，admin：项目管理员, 数据库字段：role_code */
    private String roleCode;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
