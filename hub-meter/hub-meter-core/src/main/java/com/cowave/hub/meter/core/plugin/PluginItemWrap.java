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
package com.cowave.hub.meter.core.plugin;

import cn.hutool.core.util.ReflectUtil;
import com.cowave.zoo.tools.SpringContext;
import lombok.Getter;

/**
 * @author bwcx_jzy
 */
@Getter
public class PluginItemWrap {

    /**
     * 配置相关
     */
    private final Plugin pluginConfig;

    /**
     * 插件名
     */
    private final String name;

    /**
     * 插件类名
     */
    private final Class<? extends IPlugin> className;

    /**
     * 插件对象
     */
    private volatile IPlugin plugin;

    public PluginItemWrap(Class<? extends IPlugin> className) {
        this.className = className;
        this.pluginConfig = className.getAnnotation(Plugin.class);
        this.name = this.pluginConfig.name();
    }

    public IPlugin getPlugin() {
        if (plugin == null) {
            synchronized (className) {
                if (plugin == null) {
                    //
                    boolean nativeObject = this.pluginConfig.nativeObject();
                    if (nativeObject) {
                        plugin = ReflectUtil.newInstance(className);
                    } else {
                        plugin = SpringContext.getBean(className);
                    }
                }
            }
        }
        return plugin;
    }
}
