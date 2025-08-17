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

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 表名：share_config
 * 备注：分享配置表
 *
 * @author tanghc
 */
@Data
public class ShareConfig {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 分享形式，1：公开，2：加密, 数据库字段：type */
    private Byte type;

    /** 密码, 数据库字段：password */
    private String password;

    /**  过期时间 null:永久有效 数据库字段：expiration_time */
    private LocalDate expirationTime;

    /** 状态，1：有效，0：无效, 数据库字段：status */
    private Byte status;

    /** module.id, 数据库字段：module_id */
    private Long moduleId;

    /** 是否为全部文档, 数据库字段：is_all */
    private Byte isAll;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**
     * 调试环境是否全选， 1-全选， 0-不选
     */
    private Byte isAllSelectedDebug;

    /** 备注, 数据库字段：remark */
    private String remark;

    /** 创建人, 数据库字段：creator_name */
    private String creatorName;

    /** 是否显示调试, 数据库字段：is_show_debug */
    private Byte isShowDebug;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
