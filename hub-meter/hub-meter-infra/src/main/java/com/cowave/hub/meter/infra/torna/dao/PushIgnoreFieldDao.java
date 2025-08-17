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
import com.cowave.hub.meter.domain.torna.entity.PushIgnoreField;
import com.cowave.hub.meter.infra.torna.dao.mapper.PushIgnoreFieldMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PushIgnoreFieldDao extends ServiceImpl<PushIgnoreFieldMapper, PushIgnoreField> {

    public boolean isPushIgnore(long moduleId, String dataId, String fieldName) {
        return getByDataIdAndFieldName(moduleId, dataId, fieldName) != null;
    }

    public PushIgnoreField getByDataIdAndFieldName(long moduleId, String dataId, String fieldName) {
        return lambdaQuery()
                .eq(PushIgnoreField::getModuleId, moduleId)
                .eq(PushIgnoreField::getDataId, dataId)
                .eq(PushIgnoreField::getFieldName, fieldName)
                .one();
    }
}
