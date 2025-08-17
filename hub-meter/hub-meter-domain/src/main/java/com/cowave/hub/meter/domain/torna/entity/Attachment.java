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
 * 表名：attachment 备注：附件表
 *
 * @author tanghc
 */
@Data
public class Attachment {

    /**  */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** doc_id */
    private Long docId;

    /** 文件名称 */
    private String filename;

    /** 本地保存路径 */
    private String saveDir;

    /** 文件唯一id */
    private String fileId;

    /** 上传人 */
    private Long userId;

    /** module.id */
    private Long moduleId;

    /**  */
    private Byte isDeleted;

    /**  */
    private LocalDateTime gmtCreate;

    /**  */
    private LocalDateTime gmtModified;


}
