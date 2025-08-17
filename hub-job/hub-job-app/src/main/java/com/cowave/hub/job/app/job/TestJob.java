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
package com.cowave.hub.job.app.job;

import com.cowave.zoo.tools.DateUtils;
import com.cowave.hub.job.client.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xuxueli/shanhuiming
 */
@Slf4j
@Component
public class TestJob {

    @Job("test")
    public void test(){
        log.info("=====> {}", DateUtils.format("yyyy-mm-dd MM:HH:ss SSS"));
    }
}
