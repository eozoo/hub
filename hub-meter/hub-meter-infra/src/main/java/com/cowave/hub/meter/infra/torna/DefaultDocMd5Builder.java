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
package com.cowave.hub.meter.infra.torna;

import com.cowave.hub.meter.domain.torna.bean.Booleans;
import com.cowave.hub.meter.domain.torna.dto.DocInfoDTO;
import com.cowave.hub.meter.domain.torna.dto.DocParamDTO;
import com.cowave.hub.meter.domain.torna.util.NotNullStringBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author thc
 */
public class DefaultDocMd5Builder implements DocMd5Builder {
    @Override
    public String buildMd5(DocInfoDTO docInfoDTO) {
        return getDocMd5(docInfoDTO);
    }

    public String getDocMd5(DocInfoDTO docInfoDTO) {
        NotNullStringBuilder content = new NotNullStringBuilder()
                .append(docInfoDTO.getName())
                .append(docInfoDTO.getDescription())
                .append(docInfoDTO.getAuthor())
                .append(docInfoDTO.getUrl())
                .append(docInfoDTO.getHttpMethod())
                .append(docInfoDTO.getParentId())
                .append(docInfoDTO.getFolderId())
                .append(docInfoDTO.getProjectId())
                .append(docInfoDTO.getIsUseGlobalHeaders())
                .append(docInfoDTO.getIsUseGlobalParams())
                .append(docInfoDTO.getIsUseGlobalReturns())
                .append(docInfoDTO.getIsRequestArray())
                .append(docInfoDTO.getIsResponseArray())
                .append(docInfoDTO.getRemark())
                .append(getDocParamsMd5(docInfoDTO));
        return DigestUtils.md5Hex(content.toString());
    }

    public String getDocParamsMd5(DocInfoDTO docInfoDTO) {
        StringBuilder content = new StringBuilder()
                .append(getParamsContent(docInfoDTO.getPathParams()))
                .append(getParamsContent(docInfoDTO.getHeaderParams()))
                .append(getParamsContent(docInfoDTO.getQueryParams()))
                .append(getParamsContent(docInfoDTO.getRequestParams()))
                .append(getParamsContent(docInfoDTO.getResponseParams()))
                .append(getParamsContent(docInfoDTO.getErrorCodeParams()));
        return DigestUtils.md5Hex(content.toString());
    }

    public String getParamsContent(List<DocParamDTO> docParamDTOS) {
        if (CollectionUtils.isEmpty(docParamDTOS)) {
            return "";
        }
        return docParamDTOS.stream()
                .filter(docParamDTO -> Objects.equals(docParamDTO.getIsDeleted(), Booleans.FALSE))
                .map(docParamDTO -> {
                    NotNullStringBuilder stringBuilder = new NotNullStringBuilder()
                            .append(docParamDTO.getName())
                            .append(docParamDTO.getType())
                            .append(docParamDTO.getRequired())
                            .append(docParamDTO.getDescription())
                            .append(docParamDTO.getEnumId())
                            .append(docParamDTO.getIsDeleted())
                            .append(getParamsContent(docParamDTO.getChildren()));
                    return stringBuilder.toString();
                })
                .collect(Collectors.joining());
    }

}
