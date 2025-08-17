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
 * 表名：share_content
 * 备注：分享详情
 *
 * @author tanghc
 */
@Data
public class ShareContent {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** share_config.id, 数据库字段：share_config_id */
    private Long shareConfigId;

    /** 文档id, 数据库字段：doc_id */
    private Long docId;

    /** 父id, 数据库字段：parent_id */
    private Long parentId;

    /** 是否分享整个分类, 数据库字段：is_share_folder */
    private Byte isShareFolder;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
