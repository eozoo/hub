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
package com.cowave.hub.meter.plugin.git;

import cn.hutool.core.util.URLUtil;
import com.cowave.hub.meter.core.plugin.IWorkspaceEnvPlugin;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author Hong
 */
@Slf4j
public abstract class AbstractGitProcess implements GitProcess {

    /**
     * 执行参数
     */
    protected final Map<String, Object> parameter;

    /**
     * 执行插件
     */
    private final IWorkspaceEnvPlugin workspaceEnvPlugin;
    protected final String remoteUrl;
    protected final String username;
    protected final String password;
    protected final int protocol;
    protected final String branchName;
    protected final String tagName;
    protected final Integer depth;
    protected final Integer timeout;
    protected final File savePath;
    protected final File rsaFile;
    protected final Boolean strictlyEnforce;
    protected final PrintWriter printWriter;
    protected final Integer progressRatio;

    protected AbstractGitProcess(IWorkspaceEnvPlugin workspaceEnvPlugin, Map<String, Object> parameter) {
        this.workspaceEnvPlugin = workspaceEnvPlugin;
        this.parameter = decryptParameter(parameter);
        this.remoteUrl = (String) parameter.get("url");
        this.username = URLUtil.encodeAll((String) parameter.getOrDefault("username", ""));
        this.password = URLUtil.encodeAll((String) parameter.getOrDefault("password", ""));
        this.protocol = (int) parameter.getOrDefault("protocol", 0);
        this.branchName = (String) parameter.get("branchName");
        this.tagName = (String) parameter.get("tagName");
        this.depth = (Integer) parameter.get("depth");
        this.timeout = (Integer) parameter.get("timeout");
        this.savePath = (File) parameter.get("savePath");
        this.rsaFile = (File) parameter.get("rsaFile");
        this.strictlyEnforce = (Boolean) parameter.get("strictlyEnforce");
        this.printWriter = (PrintWriter) parameter.get("logWriter");
        this.progressRatio = (Integer) parameter.get("reduceProgressRatio");
    }

    protected Map<String, Object> decryptParameter(Map<String, Object> parameter) {
//        try {
//            parameter.put("password", workspaceEnvPlugin.convertRefEnvValue(parameter, "password"));
//            parameter.put("username", workspaceEnvPlugin.convertRefEnvValue(parameter, "username"));
//        } catch (Exception e) {
//            log.error("解密参数失败", e);
//        }
        return parameter;
    }
}
