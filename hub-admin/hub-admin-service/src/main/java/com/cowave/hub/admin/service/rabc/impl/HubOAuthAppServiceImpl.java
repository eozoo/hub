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
package com.cowave.hub.admin.service.rabc.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.zoo.framework.access.Access;
import com.cowave.zoo.tools.Collections;
import com.cowave.hub.admin.domain.rabc.HubOAuthApp;
import com.cowave.hub.admin.domain.rabc.HubOAuthAppMenu;
import com.cowave.hub.admin.domain.rabc.HubRoleApp;
import com.cowave.hub.admin.domain.auth.request.RoleAppGrant;
import com.cowave.hub.admin.domain.rabc.enums.EnableStatus;
import com.cowave.hub.admin.domain.rabc.vo.OAuthAppCard;
import com.cowave.hub.admin.infra.rabc.dao.*;
import com.cowave.hub.admin.service.rabc.HubOAuthAppService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author shanhuiming
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class HubOAuthAppServiceImpl implements HubOAuthAppService {
    private final HubOAuthAppDao hubOAuthAppDao;
    private final HubUserRoleDao hubUserRoleDao;
    private final HubOAuthAppMenuDao hubOAuthAppMenuDao;
    private final HubRoleAppDao hubRoleAppDao;
    private final HubRoleAppMenuDao hubRoleAppMenuDao;

    @Override
    public Page<HubOAuthApp> listOauthApp(String tenantId, String clientName) {
        return hubOAuthAppDao.page(tenantId, clientName);
    }

    @Override
    public HubOAuthApp createOauthApp(String tenantId, HubOAuthApp oauthApp) {
        oauthApp.setTenantId(tenantId);
        oauthApp.setClientId(UUID.randomUUID().toString().replace("-", ""));
        oauthApp.setClientSecret(UUID.randomUUID().toString().replace("-", ""));
        hubOAuthAppDao.save(oauthApp);
        return oauthApp;
    }

    @Override
    public void deleteOauthApp(String tenantId, List<Integer> ids) {
        hubOAuthAppDao.removeByIds(tenantId, ids);
        hubOAuthAppMenuDao.removeByAppIds(ids);
        hubRoleAppDao.removeByAppIds(ids);
        hubRoleAppMenuDao.removeByAppIds(ids);
    }

    @Override
    public List<OAuthAppCard> getOauthAppOptions(String tenantId) {
        List<HubOAuthApp> appList = hubOAuthAppDao.listByTenantId(tenantId);
        return Collections.convertToList(appList, OAuthAppCard.class);
    }

    @Override
    public List<OAuthAppCard> getOauthAppCards() {
        List<Integer> roleIdList = hubUserRoleDao.listRoleListByUserId(Access.userId());
        if (roleIdList.isEmpty()) {
            return new ArrayList<>();
        }

        List<HubOAuthApp> appList;
        if (roleIdList.contains(1)) {
            appList = hubOAuthAppDao.listByTenantId(Access.tenantId());
        } else {
            List<HubRoleApp> roleAppList = hubRoleAppDao.listByRoleIdList(roleIdList);
            Set<Integer> appIdSet = Collections.copyToSet(roleAppList, HubRoleApp::getAppId);
            if (appIdSet.isEmpty()) {
                return new ArrayList<>();
            }
            appList = hubOAuthAppDao.listByIds(appIdSet);
        }
        return Collections.convertToList(appList, OAuthAppCard.class);
    }

    @Override
    public void grantRoleOauthApp(RoleAppGrant appGrant) {
        hubRoleAppDao.removeByRoleId(appGrant.getRoleId());
        List<Integer> appIdList = appGrant.getAppIdList();
        if(CollectionUtils.isNotEmpty(appIdList)){
            List<HubRoleApp> roleAppList = Collections.copyToList(appIdList,
                    v -> new HubRoleApp(appGrant.getRoleId(), v));
            hubRoleAppDao.saveBatch(roleAppList);
        }
    }

    @Override
    public List<Integer> getRoleOauthApp(Integer roleId) {
        return hubRoleAppDao.listByRoleId(roleId);
    }

    @Override
    public List<HubOAuthAppMenu> listAppMenus(Integer appId, String menuName, EnableStatus menuStatus) {
        return hubOAuthAppMenuDao.listMenus(appId, menuName, menuStatus);
    }
}
