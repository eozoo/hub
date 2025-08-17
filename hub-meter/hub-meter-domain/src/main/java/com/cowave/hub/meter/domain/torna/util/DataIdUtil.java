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
package com.cowave.hub.meter.domain.torna.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author tanghc
 */
public class DataIdUtil {

    private static final String TPL_PARAM = "%s:%s:%s:%s";
    private static final String TPL_ENUM = "%s:%s";

    /**
     * 文档参数唯一id，md5(doc_id:parent_id:style:name)
     * @param docId 文档id
     * @param parentId 父id
     * @param style 类型
     * @param name 文档名称
     * @return
     */
    public static String getDocParamDataId(long docId, Long parentId, byte style, String name) {
        if (name == null) {
            name = "";
        }
        if (parentId == null) {
            parentId = 0L;
        }
        String content = String.format(TPL_PARAM, docId, parentId, style, name);
        return DigestUtils.md5DigestAsHex(content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 枚举唯一id
     * @param moduleId 模块id
     * @param name 名称
     * @return
     */
    public static String getEnumInfoDataId(long moduleId, String name) {
        String content = String.format(TPL_ENUM, moduleId, name);
        return DigestUtils.md5DigestAsHex(content.getBytes(StandardCharsets.UTF_8));
    }

}
