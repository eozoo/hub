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

import org.springframework.core.env.Environment;

/**
 * 废弃，使用EnvironmentKeys代替
 * @author tanghc
 */
@Deprecated
public class EnvironmentContext {

    private static Environment environment;

    public static Environment getEnvironment() {
        return environment;
    }

    public static void setEnvironment(Environment environment) {
        EnvironmentContext.environment = environment;
    }

    /**
     * 废弃，使用EnvironmentKeys代替
     * @param key
     * @return
     */
    @Deprecated
    public static String getValue(String key) {
        return getValue(key, null);
    }

    /**
     * 废弃，使用EnvironmentKeys代替
     * @param key
     * @param defaultValue
     * @return
     */
    @Deprecated
    public static String getValue(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

}
