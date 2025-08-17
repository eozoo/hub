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
 * 表名：doc_diff_record
 * 备注：文档比较记录
 *
 * @author tanghc
 */
@Data
public class DocDiffRecord {

    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * doc_info.id
     */
    private Long docId;

    /**
     * 一个接口对应一个key
     */
    private String docKey;


    /**
     * 旧MD5
     */
    private String md5Old;


    /**
     * 新MD5
     */
    private String md5New;


    /**
     * 修改方式，0：推送，1：表单编辑
     */
    private Byte modifySource;


    /**
     * 修改人id
     */
    private Long modifyUserId;


    /**
     * 修改人
     */
    private String modifyNickname;


    /**
     * 变更类型，0：修改，1：新增，2：删除
     */
    private Byte modifyType;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;



}
