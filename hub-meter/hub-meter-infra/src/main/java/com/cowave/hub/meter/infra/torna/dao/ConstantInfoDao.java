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
package com.cowave.hub.meter.infra.torna.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.hub.meter.domain.api.ApiParam;
import com.cowave.hub.meter.domain.api.ApiCode;
import com.cowave.hub.meter.domain.torna.entity.ModuleConfig;
import com.cowave.hub.meter.domain.torna.util.HtmlTableBuilder;
import com.cowave.hub.meter.infra.torna.dao.mapper.ConstantInfoMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ConstantInfoDao extends ServiceImpl<ConstantInfoMapper, ApiCode> {

    public void setCommonErrorCodeList(List<ApiParam> docParamList, long moduleId) {
        if (CollectionUtils.isEmpty(docParamList)) {
            return;
        }
        List<ModuleConfig> moduleConfigs = docParamList.stream().map(
                docParam -> {
                    ModuleConfig config = new ModuleConfig();
                    config.setModuleId(moduleId);
                    config.setConfigKey(docParam.getName());
                    config.setConfigValue(docParam.getExample());
                    config.setDescription(docParam.getDescription());
                    return config;
                })
                .collect(Collectors.toList());
        ApiCode apiCode = this.buildConstantInfo(moduleId, moduleConfigs);
        saveModuleConstantInfo(moduleId, apiCode.getContent());
    }

    public ApiCode buildConstantInfo(long folderId, List<ModuleConfig> moduleConfigs) {
        ApiCode errorCodeInfo = new ApiCode();
        errorCodeInfo.setFolderId(folderId);
        String content = buildModuleHtmlTable(moduleConfigs);
        errorCodeInfo.setContent(content);
        return errorCodeInfo;
    }

    private String buildModuleHtmlTable(List<ModuleConfig> moduleConfigs) {
        HtmlTableBuilder htmlTableBuilder = new HtmlTableBuilder();
        htmlTableBuilder.heads("错误码", "错误描述", "解决方案");
        for (ModuleConfig moduleConfig : moduleConfigs) {
            htmlTableBuilder.addRow(
                    Arrays.asList(moduleConfig.getConfigKey(),
                            moduleConfig.getDescription(),
                            moduleConfig.getConfigValue()
                    )
            );
        }
        return htmlTableBuilder.toString();
    }

    public void saveModuleConstantInfo(long moduleId, String content) {
        ApiCode errorCodeInfo = lambdaQuery().eq(ApiCode::getFolderId, moduleId).one();
        if (errorCodeInfo == null) {
            errorCodeInfo = new ApiCode();
            errorCodeInfo.setFolderId(moduleId);
            errorCodeInfo.setContent(content);
            this.save(errorCodeInfo);
        } else {
            errorCodeInfo.setContent(content);
            this.updateById(errorCodeInfo);
        }
    }
}
