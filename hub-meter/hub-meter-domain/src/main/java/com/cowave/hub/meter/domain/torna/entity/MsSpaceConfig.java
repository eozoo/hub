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
 * 表名：ms_space_config
 * 备注：MeterSphere空间配置
 *
 * @author thc
 */
@Data
public class MsSpaceConfig {

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * MeterSphere的access_key
     */
    private String msAccessKey;

    /**
     * MeterSphere服务器地址
     */
    private String msAddress;

    /**
     * MeterSphere的secret_key
     */
    private String msSecretKey;

    /**
     * MeterSphere空间id
     */
    private String msSpaceId;

    /**
     * 空间名称
     */
    private String msSpaceName;

    /**
     * 空间id
     */
    private Long spaceId;

    /**
     * 版本号，1：2.x，2：3.x
     */
    private Integer version;


}
