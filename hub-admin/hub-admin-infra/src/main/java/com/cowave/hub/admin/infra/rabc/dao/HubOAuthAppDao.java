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
package com.cowave.hub.admin.infra.rabc.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.zoo.framework.access.Access;
import com.cowave.hub.admin.domain.rabc.HubOAuthApp;
import com.cowave.hub.admin.infra.rabc.mapper.HubOAuthAppMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shanhuiming
 */
@Repository
public class HubOAuthAppDao extends ServiceImpl<HubOAuthAppMapper, HubOAuthApp> {

    /**
     * 租户应用列表
     */
    public List<HubOAuthApp> listByTenantId(String tenantId) {
        return lambdaQuery().eq(HubOAuthApp::getTenantId, tenantId).list();
    }

    /**
     * 查询应用
     */
    public HubOAuthApp getByClientId(String clientId) {
        return lambdaQuery().eq(HubOAuthApp::getClientId, clientId).one();
    }

    /**
     * 应用列表
     */
    public Page<HubOAuthApp> page(String tenantId, String clientName) {
        return lambdaQuery()
                .eq(HubOAuthApp::getTenantId, tenantId)
                .like(StringUtils.isNotBlank(clientName), HubOAuthApp::getClientName, clientName)
                .orderByDesc(HubOAuthApp::getCreateTime)
                .page(Access.page());
    }

    /**
     * 删除应用
     */
    public void removeByIds(String tenantId, List<Integer> ids) {
        lambdaUpdate()
                .eq(HubOAuthApp::getTenantId, tenantId)
                .in(HubOAuthApp::getId, ids)
                .remove();
    }
}
