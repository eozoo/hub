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

import com.cowave.zoo.tools.SpringContext;

import java.util.function.Supplier;

/**
 * 配置工具类
 * @author thc
 */
public class Configs {

    /**
     * 获取配置参数
     * @param key 配置key
     * @return 返回配参数，没有则返回null
     */
    public static String getValue(String key) {
        return getValue(key, () -> null);
    }

    /**
     * 获取配置参数
     * @param key 配置key
     * @param defaultValue 默认值
     * @return 返回配参数，没有则返回默认值
     */
    public static String getValue(String key, String defaultValue) {
        return SpringContext.getBean(IConfig.class).getConfig(key, defaultValue);
    }

    /**
     * 获取配置参数
     * @param key 配置key
     * @param defaultValue 默认值
     * @return 返回配参数，没有则返回默认值
     */
    public static String getValue(String key, Supplier<String> defaultValue) {
        return SpringContext.getBean(IConfig.class).getConfig(key, defaultValue.get());
    }

}
