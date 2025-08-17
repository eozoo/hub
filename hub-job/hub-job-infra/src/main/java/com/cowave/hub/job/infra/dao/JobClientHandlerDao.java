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
package com.cowave.hub.job.infra.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.zoo.tools.Collections;
import com.cowave.hub.job.domain.JobClientHandler;
import com.cowave.hub.job.infra.dao.mapper.JobClientHandlerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuxueli/shanhuiming
 */
@Repository
public class JobClientHandlerDao extends ServiceImpl<JobClientHandlerMapper, JobClientHandler> {

    public void removeByClientId(Integer clientId){
        lambdaUpdate().eq(JobClientHandler::getClientId, clientId).remove();
    }

    public List<Integer> listClientByHandler(String handler){
        List<JobClientHandler> list = lambdaQuery()
                .eq(JobClientHandler::getClientHandler, handler)
                .list();
        return Collections.copyToList(list, JobClientHandler::getClientId);
    }
}
