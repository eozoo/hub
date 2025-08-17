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

import com.cowave.zoo.tools.NetUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Optional;

/**
 * @author xuxueli/shanhuiming
 */
@Data
@ConfigurationProperties(prefix = "spring.job")
public class JobProperties {

    private ServerConfig server;

    private ClientConfig client;

    public List<String> serverAddress(){
        return Optional.ofNullable(server).map(server -> server.address).orElse(null);
    }

    public String clientName(){
        return Optional.ofNullable(client).map(client -> client.name).orElse(null);
    }

    public String clientIp(){
        String ip = Optional.ofNullable(client).map(client -> client.ip).orElse(null);
        if(ip != null){
            return ip;
        }
        return NetUtils.hostIp();
    }

    public int clientPort(){
        return Optional.ofNullable(client).map(client -> client.port).orElse(3000);
    }

    @Data
    public static class ServerConfig {

        private List<String> address;
    }

    @Data
    public static class ClientConfig {

        private String name;

        private String ip;

        private int port = 3000;
    }
}
