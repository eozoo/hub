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
 * 表名：mock_config
 * 备注：mock配置
 *
 * @author tanghc
 */
@Data
public class MockConfig {

    /**  数据库字段：id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 名称, 数据库字段：name */
    private String name;

    /** md5(path+query+body), 数据库字段：data_id */
    private String dataId;

    /** mock版本号 */
    private Integer version;

    /**  数据库字段：path */
    private String path;

    /** 过滤ip, 数据库字段：ip */
    private String ip;

    /** 请求参数, 数据库字段：request_data */
    private String requestData;

    /** 参数类型，0：KV形式，1：json形式, 数据库字段：request_data_type */
    private Byte requestDataType;

    /** http状态, 数据库字段：http_status */
    private Integer httpStatus;

    /** 延迟时间，单位毫秒, 数据库字段：delay_mills */
    private Integer delayMills;

    /** 返回类型，0：自定义内容，1：脚本内容, 数据库字段：result_type */
    private Byte resultType;

    /** 响应header，数组结构, 数据库字段：response_headers */
    private String responseHeaders;

    /** 响应结果, 数据库字段：response_body */
    private String responseBody;

    /** mock脚本, 数据库字段：mock_script */
    private String mockScript;

    /** mock结果, 数据库字段：mock_result */
    private String mockResult;

    /** 文档id, 数据库字段：doc_id */
    private Long docId;

    /** 备注, 数据库字段：remark */
    private String remark;

    /** 创建人id, 数据库字段：creator_id */
    private Long creatorId;

    /** 创建人姓名, 数据库字段：creator_name */
    private String creatorName;

    /** 修改人id, 数据库字段：modifier_id */
    private Long modifierId;

    /** 修改人, 数据库字段：modifier_name */
    private String modifierName;

    /**  数据库字段：is_deleted */
    private Byte isDeleted;

    /**  数据库字段：gmt_create */
    private LocalDateTime gmtCreate;

    /**  数据库字段：gmt_modified */
    private LocalDateTime gmtModified;


}
