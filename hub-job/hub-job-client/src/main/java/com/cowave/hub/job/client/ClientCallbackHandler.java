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
package com.cowave.hub.job.client;

import com.cowave.hub.job.domain.client.TriggerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xuxueli/shanhuiming
 */
@RequiredArgsConstructor
@Slf4j
public class ClientCallbackHandler {

    private static final LinkedBlockingQueue<TriggerResponse> BACK_QUEUE = new LinkedBlockingQueue<>();

    private final ServerService serverService;

    private final List<String> serverList;

    private volatile boolean toStop = false;

    private Thread callbackThread;

    public static void pushCallBack(TriggerResponse triggerResponse) {
        BACK_QUEUE.add(triggerResponse);
    }

    public void start() {
        callbackThread = new Thread(() -> {
            while (!toStop) {
                try {
                    TriggerResponse triggerResponse = BACK_QUEUE.take();

                    List<TriggerResponse> responseList = new ArrayList<>();
                    BACK_QUEUE.drainTo(responseList);

                    responseList.add(triggerResponse);
                    doCallback(responseList);
                } catch (Throwable e) {
                    if (!toStop) {
                        log.error("", e);
                    }
                }
            }

            try {
                List<TriggerResponse> responseList = new ArrayList<>();
                BACK_QUEUE.drainTo(responseList);
                if (!responseList.isEmpty()) {
                    doCallback(responseList);
                }
            } catch (Throwable e) {
                if (!toStop) {
                    log.error("", e);
                }
            }
        });
        callbackThread.setDaemon(true);
        callbackThread.setName("job-client-callback");
        callbackThread.start();
    }

    public void toStop() {
        toStop = true;
        if (callbackThread != null) {
            callbackThread.interrupt();
            try {
                callbackThread.join();
            } catch (Throwable e) {
                log.error("", e);
            }
        }
    }

    private void doCallback(List<TriggerResponse> responseList) {
        for (String serverAddress : serverList) {
            try {
                serverService.callback("http://" + serverAddress, responseList);
            } catch (Exception e) {
                log.error("", e);
            }
        }
    }
}
