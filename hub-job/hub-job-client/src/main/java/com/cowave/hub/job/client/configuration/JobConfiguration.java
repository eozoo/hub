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
package com.cowave.hub.job.client.configuration;

import com.cowave.zoo.framework.configuration.ApplicationProperties;
import com.cowave.hub.job.client.JobContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({ApplicationProperties.class, JobProperties.class})
public class JobConfiguration {

    @Bean
    public JobContext jobContext(ApplicationProperties applicationProperties, JobProperties jobProperties) {
		String clientName = jobProperties.clientName();
		if(StringUtils.isBlank(clientName)){
			clientName = applicationProperties.getName();
		}
		if(StringUtils.isBlank(clientName)){
			clientName = "unknown";
		}

		JobContext jobContext = new JobContext();
		jobContext.setClinetName(clientName);
        jobContext.setClientIp(jobProperties.clientIp());
		jobContext.setClientPort(jobProperties.clientPort());
        jobContext.setServerList(jobProperties.serverAddress());
		return jobContext;
	}
}
