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

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.cowave.hub.meter.core.plugin.IWorkspaceEnvPlugin;
import com.cowave.hub.meter.core.utils.CommandUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author Hong
 **/
@Slf4j
public class GitProcessFactory {
    private static Boolean result;
    private static final String WIN_EXISTS_GIT = "where git";
    private static final String LINUX_EXISTS_GIT = "which git";
    private static final String DEFAULT_GIT_PROCESS = "JGit";
    private static final String SYSTEM_GIT_PROCESS = "SystemGit";

    public static GitProcess get(Map<String, Object> parameter, IWorkspaceEnvPlugin workspaceEnvPlugin) {
        String processType = (String) parameter.getOrDefault("gitProcessType", DEFAULT_GIT_PROCESS);
        if (SYSTEM_GIT_PROCESS.equalsIgnoreCase(processType) && GitProcessFactory.isGitExists()) {
            return new SystemGitProcess(workspaceEnvPlugin, parameter);
        } else {
            return new JGitProcess(workspaceEnvPlugin, parameter);
        }
    }

    public static boolean isGitExists() {
        if (result == null) {
            result = existsGit();
        }
        return result;
    }

    private static boolean existsGit() {
        String result;
        OsInfo osInfo = SystemUtil.getOsInfo();
        if (osInfo.isWindows()) {
            result = CommandUtil.execCommand(WIN_EXISTS_GIT);
            return StrUtil.contains(result, ".exe");
        } else if (osInfo.isLinux() || osInfo.isMac()) {
            result = CommandUtil.execCommand(LINUX_EXISTS_GIT);
            return !StrUtil.containsAny(result, "no git", "not found");
        } else {
            return false;
        }
    }
}
