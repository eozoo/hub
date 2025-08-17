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
package com.cowave.hub.meter.domain.torna.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.cowave.hub.meter.domain.torna.bean.Booleans;
import com.cowave.hub.meter.domain.torna.bean.DocInfoDataId;
import com.cowave.hub.meter.domain.torna.bean.User;
import com.cowave.hub.meter.domain.torna.enums.DocTypeEnum;
import com.cowave.hub.meter.domain.torna.support.IdCodec;
import lombok.Data;

import java.util.Map;

/**
 * @author tanghc
 */
@Data
public class DocFolderCreateDTO implements DocInfoDataId {
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long folderId;

    private String name;

    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long parentId;

    /** 维护人, 数据库字段：author */
    private String author;

    private Integer orderIndex;

    private DocTypeEnum docTypeEnum;

    private Map<String, ?> props;

    private User user;

    @Override
    public Byte getIsGroup() {
        return Booleans.TRUE;
    }

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public String getHttpMethod() {
        return "";
    }
}
