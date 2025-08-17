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
package com.cowave.hub.meter.infra.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.hub.meter.domain.torna.bean.Booleans;
import com.cowave.hub.meter.domain.api.ApiDefinition;
import com.cowave.hub.meter.domain.torna.enums.OperationMode;
import com.cowave.hub.meter.infra.api.dao.mapper.ApiDefinitionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiDefinitionDao extends ServiceImpl<ApiDefinitionMapper, ApiDefinition> {

    /**
     * 获取Module文档
     */
    public List<ApiDefinition> listByFolderId(Long folderId) {
        return lambdaQuery().eq(ApiDefinition::getFolderId, folderId).list();
    }

    public ApiDefinition getByDocId(Long docId) {
        return lambdaQuery()
                .eq(ApiDefinition::getId, docId)
                .eq(ApiDefinition::getIsShow, Booleans.TRUE)
                .one();
    }

    public List<ApiDefinition> listByDocIds(List<Long> docIds) {
        return lambdaQuery()
                .in(ApiDefinition::getId, docIds)
                .eq(ApiDefinition::getIsShow, Booleans.TRUE)
                .list();
    }


    public List<Long> listDocIdByModuleId(Long moduleId) {
        return lambdaQuery()
                .eq(ApiDefinition::getFolderId, moduleId)
                .select(ApiDefinition::getFolderId)
                .list().stream().map(ApiDefinition::getId).toList();
    }

    public void deleteOpenAPIModuleDocs(long moduleId) {
        lambdaUpdate()
                .eq(ApiDefinition::getFolderId, moduleId)
                .eq(ApiDefinition::getCreateMode, OperationMode.OPEN.getType())
                .eq(ApiDefinition::getIsLocked, Booleans.FALSE)
                .and(wrapper -> wrapper
                        .isNull(ApiDefinition::getVersion)
                        .or()
                        .eq(ApiDefinition::getVersion, "")
                ).remove();
    }
}
