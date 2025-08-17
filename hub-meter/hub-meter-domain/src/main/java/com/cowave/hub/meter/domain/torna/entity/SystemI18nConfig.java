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
 * 表名：system_i18n_config
 * 备注：国际化配置
 *
 * @author tanghc
 */
@Data
public class SystemI18nConfig {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 语言简写，如:zh,en
     */
    private String lang;


    /**
     * 描述，如：简体中文
     */
    private String description;


    /**
     * 配置项，properties文件内容
     */
    private String content;


    private Byte isDeleted;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;


}
