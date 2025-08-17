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
package com.cowave.hub.meter.infra.env;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.zoo.framework.access.Access;
import com.cowave.hub.meter.domain.env.EnvCredential;
import com.cowave.hub.meter.domain.env.request.CredentialQuery;
import com.cowave.hub.meter.infra.env.mapper.EnvCredentialMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * @author shanhuiming
 */
@Repository
public class EnvCredentialDao extends ServiceImpl<EnvCredentialMapper, EnvCredential> {

    /**
     * 分页列表
     */
    public Page<EnvCredential> pageList(CredentialQuery query) {
        return lambdaQuery()
                .like(StringUtils.isNotBlank(query.getCredentialName()), EnvCredential::getCredentialName, query.getCredentialName())
                .ge(query.getBeginTime() != null, EnvCredential::getCreateTime, query.getBeginTime())
                .le(query.getEndTime() != null, EnvCredential::getCreateTime, query.getEndTime())
                .page(Access.page());
    }
}
