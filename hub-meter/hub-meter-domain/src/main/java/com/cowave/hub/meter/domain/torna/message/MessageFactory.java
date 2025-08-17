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
package com.cowave.hub.meter.domain.torna.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/**
 * 管理国际化资源
 *
 * @author tanghc
 */
@Slf4j
public class MessageFactory {

    private MessageFactory() {
    }

    /**
     * 国际化信息
     */
    private static MessageSourceAccessor errorMessageSourceAccessor;

    /**
     * 设置国际化资源信息
     */
    public static void initMessageSource(List<String> modules) {
        HashSet<String> baseNamesSet = new HashSet<>();

        if (!modules.isEmpty()) {
            baseNamesSet.addAll(modules);
        }

        String[] totalBaseNames = baseNamesSet.toArray(new String[0]);

        log.info("加载国际化资源：{}", StringUtils.arrayToCommaDelimitedString(totalBaseNames));
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasenames(totalBaseNames);
        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(bundleMessageSource);
        setErrorMessageSourceAccessor(messageSourceAccessor);
    }

    /**
     * 通过MessageMeta，Locale，params构建国际化错误消息
     *
     * @param messageMeta 错误信息
     * @param locale      本地化
     * @param params      参数
     * @return 返回消息对象
     */
    public static Message getError(MessageMeta messageMeta, Locale locale, Object... params) {
        if (locale == null) {
            locale = Locale.SIMPLIFIED_CHINESE;
        }
        String content = getErrorMessage(messageMeta.getKey(), locale, params);
        return Message.builder()
                .content(content)
                .build();
    }


    public static void setErrorMessageSourceAccessor(MessageSourceAccessor errorMessageSourceAccessor) {
        MessageFactory.errorMessageSourceAccessor = errorMessageSourceAccessor;
    }

    /**
     * 返回本地化信息
     *
     * @param module 错误模块
     * @param locale 本地化
     * @param params 参数
     * @return 返回信息
     */
    public static String getErrorMessage(String module, Locale locale, Object... params) {
        try {
            return errorMessageSourceAccessor.getMessage(module, params, locale);
        } catch (Exception e) {
            return "";
        }
    }

}
