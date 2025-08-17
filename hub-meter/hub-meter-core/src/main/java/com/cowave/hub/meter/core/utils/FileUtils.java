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
package com.cowave.hub.meter.core.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Lombok;

import java.io.File;
import java.nio.charset.Charset;
import java.util.function.Function;

/**
 * @author bwcx_jzy
 */
public class FileUtils {

    /**
     * 目录是否越级
     */
    public static void checkSlip(String dir) {
        checkSlip(dir, e -> new IllegalArgumentException("目录不能越级: " + e.getMessage()));
    }

    /**
     * 目录是否越级
     */
    public static void checkSlip(String dir, Function<Exception, Exception> function) {
        try {
            File tmpDir = FileUtil.getTmpDir();
            FileUtil.checkSlip(tmpDir, FileUtil.file(tmpDir, dir));
        } catch (IllegalArgumentException e) {
            throw Lombok.sneakyThrow(function.apply(e));
        }
    }

    /**
     * 使用当前系统的换行符写文件
     */
    public static void writeScript(String context, File scriptFile, Charset charset) {
        String replace = StrUtil.replace(context, StrUtil.LF, FileUtil.getLineSeparator());
        FileUtil.writeString(replace, scriptFile, charset);
    }
}
