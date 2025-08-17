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
package com.cowave.hub.job.domain.enums;

import com.cowave.zoo.tools.EnumVal;
import lombok.Getter;

/**
 * @author xuxueli/shanhuiming
 */
@Getter
public enum JobTaskType implements EnumVal<Void> {

    /**
     * BEAN
     */
    BEAN("BEAN", false, null, null),

    /**
     * GROOVY
     */
    GROOVY("GROOVY", false, null, null),

    /**
     * SHELL
     */
    SHELL("SHELL", true, "bash", ".sh"),

    /**
     * PYTHON
     */
    PYTHON("PYTHON", true, "python", ".py"),

    /**
     * PHP
     */
    PHP("PHP", true, "php", ".php"),

    /**
     * NODEJS
     */
    NODEJS("NODEJS", true, "node", ".js"),

    /**
     * POWERSHELL
     */
    POWERSHELL("POWERSHELL", true, "powershell", ".ps1");

    private final String desc;
    private final boolean isScript;
    private final String cmd;
    private final String suffix;

    JobTaskType(String desc, boolean isScript, String cmd, String suffix) {
        this.desc = desc;
        this.isScript = isScript;
        this.cmd = cmd;
        this.suffix = suffix;
    }

    public boolean isScript() {
        return isScript;
    }
}
