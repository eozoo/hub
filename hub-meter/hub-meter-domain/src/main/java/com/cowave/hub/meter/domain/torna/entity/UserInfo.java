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
 * 表名：user_info
 * 备注：用户表
 *
 * @author tanghc
 */
@Data
public class UserInfo {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 登录账号/邮箱, 数据库字段：username */
    private String username;

    /** 登录密码, 数据库字段：password */
    private String password;

    /** 昵称, 数据库字段：nickname */
    private String nickname;

    /** 是否是超级管理员, 数据库字段：is_super_admin */
    private Byte isSuperAdmin;

    /**  数据库字段：source */
    private String source;

    /**  数据库字段：email */
    private String email;

    /** 0：禁用，1：启用，2：重设密码, 数据库字段：status */
    private Byte status;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
