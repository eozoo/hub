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
package com.cowave.hub.admin.service.rabc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.hub.admin.domain.rabc.HubOAuthApp;
import com.cowave.hub.admin.domain.auth.request.RoleAppGrant;
import com.cowave.hub.admin.domain.rabc.HubOAuthAppMenu;
import com.cowave.hub.admin.domain.rabc.enums.EnableStatus;
import com.cowave.hub.admin.domain.rabc.vo.OAuthAppCard;

import java.util.List;

/**
 * @author shanhuiming
 */
public interface HubOAuthAppService {

    /**
     * 授权应用列表
     */
    Page<HubOAuthApp> listOauthApp(String tenantId, String clientName);

    /**
     * 新增授权应用
     */
    HubOAuthApp createOauthApp(String tenantId, HubOAuthApp oauthApp);

    /**
     * 删除授权应用
     */
    void deleteOauthApp(String tenantId, List<Integer> ids);

    /**
     * 授权应用选项
     */
    List<OAuthAppCard> getOauthAppOptions(String tenantId);

    /**
     * 应用卡片列表
     */
    List<OAuthAppCard> getOauthAppCards();

    /**
     * 给角色授权应用
     */
    void grantRoleOauthApp(RoleAppGrant appGrant);

    /**
     * 获取角色授权应用
     */
    List<Integer> getRoleOauthApp(Integer roleId);

    /**
     * 应用菜单列表
     */
    List<HubOAuthAppMenu> listAppMenus(Integer appId, String menuName, EnableStatus menuStatus);
}
