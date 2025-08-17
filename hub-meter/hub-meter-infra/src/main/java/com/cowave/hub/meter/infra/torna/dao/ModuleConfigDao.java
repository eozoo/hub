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
import com.cowave.hub.meter.domain.torna.entity.ModuleConfig;
import com.cowave.hub.meter.domain.torna.enums.ModuleConfigTypeEnum;
import com.cowave.hub.meter.infra.torna.dao.mapper.ModuleConfigMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ModuleConfigDao extends ServiceImpl<ModuleConfigMapper, ModuleConfig> {

    public String getCommonConfigValue(long moduleId, String key, String defaultValue) {
        ModuleConfig commonConfig = getCommonConfig(moduleId, key);
        return Optional.ofNullable(commonConfig)
                .map(ModuleConfig::getConfigValue)
                .orElse(defaultValue);
    }

    public ModuleConfig getCommonConfig(long moduleId, String key) {
        return getModuleConfig(moduleId, key, ModuleConfigTypeEnum.COMMON, false);
    }

    public ModuleConfig getModuleConfig(long moduleId, String key, ModuleConfigTypeEnum type, boolean forceQuery) {
        return lambdaQuery()
                .eq(ModuleConfig::getModuleId, moduleId)
                .eq(ModuleConfig::getType, type.getType())
                .eq(ModuleConfig::getConfigKey, key)
                .one();
    }
}
