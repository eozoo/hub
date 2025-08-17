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
 * 表名：prop
 * 备注：属性表
 *
 * @author tanghc
 */
@Data
public class Prop {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关联id, 数据库字段：ref_id */
    private Long refId;

    /** 类型，0：doc_info属性, 数据库字段：type */
    private Byte type;

    /**  数据库字段：name */
    private String name;

    /**  数据库字段：val */
    private String val;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
