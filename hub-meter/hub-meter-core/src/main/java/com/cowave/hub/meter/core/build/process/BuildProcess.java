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
package com.cowave.hub.meter.core.build.process;

import cn.hutool.core.io.IoUtil;
import com.cowave.hub.meter.core.JpomApplication;
import com.cowave.hub.meter.core.utils.CommandExec;
import com.cowave.hub.meter.core.utils.LogRecorder;
import lombok.Lombok;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bwcx_jzy
 */
@RequiredArgsConstructor
public class BuildProcess implements ProcessItem {

    /**
     * 执行id
     */
    private String processId = "xxxx1";

    /**
     * 执行参数
     */
    private String args = "";

    /**
     * 执行脚本
     */
    private String processScript = "echo 123";

    /**
     * 环境变量
     */
    private Map<String, String> env = new HashMap<>();

    /**
     * 执行目录
     */
    private final File workHome;

    /**
     * 执行输出
     */
    private final LogRecorder logRecorder;

    @Override
    public String name() {
        return "Build";
    }

    @Override
    public Integer process() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("script/template.sh")) {
            String script = IoUtil.readUtf8(inputStream) + processScript;
            return JpomApplication.getInstance().execScript(script, file -> {
                try {
                    return CommandExec.execScript(processId, file, workHome, env, "", logRecorder);
                } catch (Exception e) {
                    throw Lombok.sneakyThrow(e);
                }
            });
        } catch (Exception e) {
            logRecorder.info(e.getMessage());
            return -1;
        }
    }
}
