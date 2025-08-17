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
import com.cowave.hub.meter.domain.torna.bean.EnvironmentKeys;
import com.cowave.hub.meter.domain.torna.bean.IConfig;
import com.cowave.hub.meter.domain.torna.entity.SystemConfig;
import com.cowave.hub.meter.infra.torna.EnvironmentContext;
import com.cowave.hub.meter.infra.torna.dao.mapper.SystemConfigMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class SystemConfigDao extends ServiceImpl<SystemConfigMapper, SystemConfig> implements IConfig, InitializingBean {

    private final Environment environment;

    private final LoadingCache<String, Optional<String>> configCache = CacheBuilder.newBuilder()
            .expireAfterAccess(15, TimeUnit.MINUTES)
            .build(new CacheLoader<>() {
                @Override
                public Optional<String> load(String key) throws Exception {
                    return Optional.ofNullable(getConfigValue(key, null));
                }
            });

    public String getConfigValue(String key, String defaultValue) {
        Objects.requireNonNull(key, "need key");
        SystemConfig systemConfig = getByKey(key);
        return Optional.ofNullable(systemConfig).map(SystemConfig::getConfigValue)
                .orElseGet(() -> {
                    String value = EnvironmentContext.getValue(key, defaultValue);
                    if (value == null) {
                        EnvironmentKeys environmentKeys = EnvironmentKeys.of(key);
                        if (environmentKeys != null && environmentKeys.getDefaultValue() != null) {
                            value = environmentKeys.getDefaultValue();
                        }
                    }
                    return value;
                });
    }

    public SystemConfig getByKey(String key) {
        return lambdaQuery().eq(SystemConfig::getConfigKey, key).one();
    }

    @Override
    public String getConfig(String key) {
        return configCache.getUnchecked(key).orElse(null);
    }

    @Override
    public String getConfig(String key, String defaultValue) {
        return configCache.getUnchecked(key).orElse(defaultValue);
    }

    @Override
    public void afterPropertiesSet() {
        EnvironmentContext.setEnvironment(environment);
        List<SystemConfig> configList = list();
        configList.forEach(systemConfig -> {
            configCache.put(systemConfig.getConfigKey(), Optional.of(systemConfig.getConfigValue()));
        });
    }
}
