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

import com.cowave.hub.meter.core.Const;

import java.util.Map;

/**
 * @author bwcx_jzy
 */
public interface IWorkspaceEnvPlugin extends IDefaultPlugin {

    String PLUGIN_NAME = "workspace-Env";

    /**
     * 转化 工作空间环境变量
     *
     * @param parameter 插件的参数
     * @param key       参数中的key
     * @return 转化后的
     * @throws Exception 异常
     */
    default String convertRefEnvValue(Map<String, Object> parameter, String key) throws Exception {
        String workspaceId = (String) parameter.get(Const.WORKSPACE_ID_REQ_HEADER);
        return this.convertRefEnvValue(workspaceId, (String) parameter.get(key));
    }

    /**
     * 转化 工作空间环境变量
     *
     * @param workspaceId 工作空间
     * @param value       值
     * @return 如果存在值，则返回环境变量值。不存在则返回原始值
     * @throws Exception 异常
     */
    default String convertRefEnvValue(String workspaceId, String value) throws Exception {
        return (String) PluginFactory.getPlugin(PLUGIN_NAME).execute("convert", "workspaceId", workspaceId, "value", value);
    }
}
