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
import com.cowave.hub.meter.domain.api.ApiParam;
import com.cowave.hub.meter.domain.torna.enums.OperationMode;
import com.cowave.hub.meter.infra.api.dao.mapper.ApiParamMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiParamDao extends ServiceImpl<ApiParamMapper, ApiParam> {

    public void deletePushParam(List<Long> docIdList) {
        lambdaUpdate()
                .in(ApiParam::getApiId, docIdList)
                .eq(ApiParam::getCreateMode, OperationMode.OPEN.getType())
                .remove();
    }

    public ApiParam getByDataId(String dataId) {
        return lambdaQuery().eq(ApiParam::getDataId, dataId).one();
    }

    public List<ApiParam> listByDocId(Long docId) {
        return lambdaQuery().eq(ApiParam::getApiId, docId).list();
    }
}
