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
package com.cowave.hub.meter.domain.torna.bean;

import com.cowave.hub.meter.domain.torna.enums.DocTypeEnum;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 唯一id，接口规则：md5(module_id:parent_id:url:http_method)。
 * 分类规则：md5(module_id:parent_id:name)
 * @author tanghc
 */
public interface DocInfoDataId {

    String TPL_API = "%s:%s:%s";
    String TPL_FOLDER = "%s:%s:%s";

    default String buildDataId() {
        String content = buildDocKey();
        String version = getVersion();
        if ("-".equals(version) || version == null) {
            version = "";
        }
        content = content + version;
        return DigestUtils.md5DigestAsHex(content.getBytes(StandardCharsets.UTF_8));
    }

    default String buildDocKey() {
        Long parentId = getParentId();
        if (parentId == null) {
            parentId = 0L;
        }
        String content;
        if (Booleans.isTrue(this.getIsGroup())) {
            content = String.format(TPL_FOLDER, getFolderId(), parentId, getName());
        } else if (!Objects.equals(getType(), DocTypeEnum.HTTP.getType())) {
            content = String.format(TPL_API, getFolderId(), getName(), DocTypeEnum.CUSTOM);
        } else {
            content = String.format(TPL_API, getFolderId(), getUrl(), getHttpMethod());
        }
        return DigestUtils.md5DigestAsHex(content.getBytes(StandardCharsets.UTF_8));
    }

    String getName();

    Long getFolderId();

    Long getParentId();

    Byte getIsGroup();

    String getUrl();

    String getHttpMethod();

    default Byte getType() {
        return DocTypeEnum.HTTP.getType();
    }

    default String getVersion() {
        return "";
    }
}
