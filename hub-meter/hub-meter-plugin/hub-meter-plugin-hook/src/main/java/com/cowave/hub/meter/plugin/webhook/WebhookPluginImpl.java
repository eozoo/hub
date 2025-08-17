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
package com.cowave.hub.meter.plugin.webhook;

import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.cowave.hub.meter.core.plugin.IDefaultPlugin;
import com.cowave.hub.meter.core.plugin.Plugin;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author bwcx_jzy
 */
@Slf4j
@Plugin(name = "webhook")
public class WebhookPluginImpl implements IDefaultPlugin {

    @Override
    public Object execute(Object main, Map<String, Object> parameter) {
        String webhook = StrUtil.toStringOrNull(main);
        if (StrUtil.isEmpty(webhook)) {
            return null;
        }

        Object hookEvent = parameter.remove("HOOK_EVENT");
        if (hookEvent instanceof WebhookEvent webhookEvent) {
            log.debug("webhook event: [{}]{}", webhookEvent, webhook);
        }

        try {
            HttpRequest httpRequest = HttpUtil.createGet(webhook, true);
            httpRequest.form(parameter);
            try (HttpResponse execute = httpRequest.execute()) {
                String body = execute.body();
                log.info("{}" + CharPool.COLON + "{}", webhook, body);
                return body;
            }
        } catch (Exception e) {
            log.error("webHook调用失败", e);
            return "WebHooks error:" + e.getMessage();
        }
    }
}
