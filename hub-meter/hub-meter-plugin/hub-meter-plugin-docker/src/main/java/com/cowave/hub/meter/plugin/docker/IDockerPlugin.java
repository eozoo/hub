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
package com.cowave.hub.meter.plugin.docker;

import cn.hutool.core.io.FileUtil;
import com.cowave.hub.meter.core.plugin.IDefaultPlugin;

import java.io.File;
import java.io.InputStream;

/**
 * @author bwcx_jzy
 */
public interface IDockerPlugin extends IDefaultPlugin {

    /**
     * 获取 配置资源
     *
     * @param name 配置文件名称
     * @return 文件流
     */
    @Override
    default InputStream getConfigResourceInputStream(String name) {
        String newName = "docker/" + name;
        return IDefaultPlugin.super.getConfigResourceInputStream(newName);
    }

    /**
     * 获取配置文件
     *
     * @param name    配置文件名称
     * @param tempDir 保存目录
     * @return file
     */
    default File getResourceToFile(String name, File tempDir) {
        InputStream stream = this.getConfigResourceInputStream(name);
        if (stream == null) {
            return null;
        }
        File tempFile = DockerUtil.createTemp(name, tempDir);
        FileUtil.writeFromStream(stream, tempFile);
        return tempFile;
    }
}
