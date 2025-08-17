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
package com.cowave.hub.meter.core.common;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;

import java.util.function.Function;

/**
 * @author bwcx_jzy
 */
public enum Type {
    Agent("org.dromara.jpom.JpomAgentApplication", (remoteVersion) -> {
        String jpomRemoteVersionAuth = SystemUtil.get("JPOM_REMOTE_VERSION_AUTH", "");
        if (StrUtil.isNotEmpty(jpomRemoteVersionAuth)) {
            RemoteVersion.RemoteVersionAuth auth = remoteVersion.getAuth();
            if (auth != null && StrUtil.isNotEmpty(auth.getAgentUrl())) {
                String agentUrl = auth.getAgentUrl();
                return StrUtil.replace(agentUrl, "{token}", jpomRemoteVersionAuth);
            }
        }

        return remoteVersion.getAgentUrl();
    }, "JPOM_AGENT_APPLICATION"),

    Server("org.dromara.jpom.JpomServerApplication", (remoteVersion) -> {
        String jpomRemoteVersionAuth = SystemUtil.get("JPOM_REMOTE_VERSION_AUTH", "");
        if (StrUtil.isNotEmpty(jpomRemoteVersionAuth)) {
            RemoteVersion.RemoteVersionAuth auth = remoteVersion.getAuth();
            if (auth != null && StrUtil.isNotEmpty(auth.getServerUrl())) {
                String serverUrl = auth.getServerUrl();
                return StrUtil.replace(serverUrl, "{token}", jpomRemoteVersionAuth);
            }
        }
        return remoteVersion.getServerUrl();
    }, "JPOM_SERVER_APPLICATION");

    private final Function<RemoteVersion, String> remoteUrl;

    private final String applicationClass;

    private final String tag;

    private Type(String applicationClass, Function<RemoteVersion, String> remoteUrl, String tag) {
        this.applicationClass = applicationClass;
        this.remoteUrl = remoteUrl;
        this.tag = tag;
    }

    public String getRemoteUrl(RemoteVersion remoteVersion) {
        return (String)this.remoteUrl.apply(remoteVersion);
    }

    public Function<RemoteVersion, String> getRemoteUrl() {
        return this.remoteUrl;
    }

    public String getApplicationClass() {
        return this.applicationClass;
    }

    public String getTag() {
        return this.tag;
    }
}
