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

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.JarClassLoader;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.cowave.hub.meter.core.common.JpomManifest;
import com.cowave.hub.meter.core.utils.ExtConfigFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.*;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.File;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToIntFunction;

/**
 * @author bwcx_jzy
 */
@Slf4j
@Component
public class PluginFactory implements ApplicationContextInitializer<ConfigurableApplicationContext>, ApplicationListener<ApplicationEvent> {

    private static final Map<String, List<PluginItemWrap>> PLUGIN_HOLD = new ConcurrentHashMap<>();

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Set<Class<?>> classes = ClassUtil.scanPackage("com.cowave.sys.meter.plugin", IPlugin.class::isAssignableFrom);
        List<PluginItemWrap> pluginItemWraps = classes.stream()
                .filter(clazz -> ClassUtil.isNormalClass(clazz) && clazz.isAnnotationPresent(Plugin.class))
                .map(clazz -> new PluginItemWrap((Class<? extends IPlugin>) clazz))
                .filter(pluginItemWrap -> {
                    if (StrUtil.isEmpty(pluginItemWrap.getName())) {
                        log.warn("invalid plugin name, {}", pluginItemWrap.getClassName());
                        return false;
                    }
                    log.info("load plugin ============> {}[{}]", pluginItemWrap.getName(), pluginItemWrap.getClassName());
                    return true;
                }).toList();
        // 加载
        Map<String, List<PluginItemWrap>> pluginMap = CollStreamUtil.groupByKey(pluginItemWraps, PluginItemWrap::getName);
        pluginMap.forEach((key, value) -> {
            value.sort((o1, o2) -> Comparator.comparingInt(
                    (ToIntFunction<PluginItemWrap>) value1 -> {
                        Order order = value1.getClassName().getAnnotation(Order.class);
                        if (order == null) {
                            return 0;
                        }
                        return order.value();
                    }).compare(o1, o2));
            PLUGIN_HOLD.put(key, value);
        });
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            Collection<List<PluginItemWrap>> values = PLUGIN_HOLD.values();
            for (List<PluginItemWrap> value : values) {
                for (PluginItemWrap pluginItemWrap : value) {
                    IoUtil.close(pluginItemWrap.getPlugin());
                }
            }
        } else if (event instanceof ApplicationReadyEvent) {
            ApplicationContext applicationContext = ((ApplicationReadyEvent) event).getApplicationContext();
            System.setProperty(IPlugin.DATE_PATH_KEY, ExtConfigFile.getPath());
            System.setProperty(IPlugin.JPOM_VERSION_KEY, JpomManifest.getInstance().getVersion());
        }
    }

    /**
     * 获取插件端
     *
     * @param name 插件名
     * @return 插件对象
     */
    public static IPlugin getPlugin(String name) {
        List<PluginItemWrap> pluginItemWraps = PLUGIN_HOLD.get(name);
        PluginItemWrap first = CollUtil.getFirst(pluginItemWraps);
        Assert.notNull(first, "对应找到对应到插件：" + name);
        return first.getPlugin();
    }

    /**
     * 判断是否包含某个插件
     *
     * @param name 插件名
     * @return true 包含
     */
    public static boolean contains(String name) {
        return PLUGIN_HOLD.containsKey(name);
    }

    /**
     * 插件数量
     *
     * @return 当前加载的插件数量
     */
    public static int size() {
        return PLUGIN_HOLD.size();
    }

    /**
     * 正式环境添加依赖
     */
    private static void init() {
        File runPath = JpomManifest.getRunPath().getParentFile();
        File plugin = FileUtil.file(runPath, "plugin");
        if (!plugin.exists() || plugin.isFile()) {
            return;
        }
        // 加载二级插件包
        File[] dirFiles = plugin.listFiles(File::isDirectory);
        if (dirFiles != null) {
            for (File file : dirFiles) {
                File lib = FileUtil.file(file, "lib");
                if (!lib.exists() || lib.isFile()) {
                    continue;
                }
                File[] listFiles = lib.listFiles((dir, name) -> StrUtil.endWith(name, FileUtil.JAR_FILE_EXT, true));
                if (listFiles == null || listFiles.length == 0) {
                    continue;
                }
                addPlugin(file.getName(), lib);
            }
        }
        // 加载一级独立插件端包
        File[] files = plugin.listFiles(pathname -> FileUtil.isFile(pathname) && FileUtil.JAR_FILE_EXT.equalsIgnoreCase(FileUtil.extName(pathname)));
        if (files != null) {
            for (File file : files) {
                addPlugin(file.getName(), file);
            }
        }
    }

    private static void addPlugin(String pluginName, File file) {
        ClassLoader contextClassLoader = ClassLoaderUtil.getClassLoader();
        JarClassLoader.loadJar((URLClassLoader) contextClassLoader, file);
    }
}
