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
 * 表名：module_environment
 * 备注：模块调试环境
 *
 * @author tanghc
 */
@Data
public class ModuleEnvironment {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** module.id, 数据库字段：module_id */
    private Long moduleId;

    /** 环境名称, 数据库字段：name */
    private String name;

    /** 调试路径, 数据库字段：url */
    private String url;

    /** 是否公开, 数据库字段：is_public */
    private Byte isPublic;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
