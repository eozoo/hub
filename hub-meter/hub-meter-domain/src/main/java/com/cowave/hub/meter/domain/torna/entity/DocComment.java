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
 * 表名：doc_comment
 * 备注：文档评论表
 *
 * @author tanghc
 */
@Data
public class DocComment {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * doc_info.id
     */
    private Long docId;

    /**
     * 评论人
     */
    private Long userId;

    /**
     * 评论人昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复id，即：parent_id
     */
    private Long replyId;

    private Byte isDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;


}
