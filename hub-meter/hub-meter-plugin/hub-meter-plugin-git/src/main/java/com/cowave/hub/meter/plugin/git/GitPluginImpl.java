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

import com.cowave.hub.meter.core.plugin.IWorkspaceEnvPlugin;
import com.cowave.hub.meter.core.plugin.Plugin;
import org.eclipse.jgit.api.Git;

import java.util.Map;

/**
 * @author Hong
 */
@Plugin(name = "git")
public class GitPluginImpl implements IWorkspaceEnvPlugin {

    @Override
    public Object execute(Object main, Map<String, Object> parameter) throws Exception {
        GitProcess gitProcess = GitProcessFactory.get(parameter, this);
        String type = main.toString();
        return switch (type) {
            case "listBranchAndTag" -> gitProcess.listBranchAndTag();
            case "pullBranch" -> gitProcess.pullBranch();
            case "pullTag" -> gitProcess.pullTag();
            case "isGitExists" -> GitProcessFactory.isGitExists();
            default -> null;
        };
    }

    @Override
    public void close() {
        Git.shutdown();
    }
}
