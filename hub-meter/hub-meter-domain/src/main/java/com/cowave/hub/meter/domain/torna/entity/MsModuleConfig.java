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
 * 表名：ms_module_config
 * 备注：MeterSphere模块配置
 *
 * @author thc
 */
@Data
public class MsModuleConfig {

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * module.id
     */
    private Long moduleId;

    /**
     * project_release.id
     */
    private Long releaseId;

    /**
     * 默认覆盖
     */
    private Byte msCoverModule;

    /**
     * MeterSphere模块id
     */
    private String msModuleId;

    /**
     * MeterSphere项目id
     */
    private String msProjectId;

    private String name;


}
