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
package com.cowave.hub.admin.service.auth;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.zoo.framework.access.security.AccessUserDetails;
import com.cowave.hub.admin.domain.auth.HubOAuth;
import com.cowave.hub.admin.domain.auth.HubOAuthUser;
import com.cowave.hub.admin.domain.auth.request.OAuth2CodeRequest;
import com.cowave.hub.admin.domain.auth.request.OAuth2TokenRequest;
import com.cowave.hub.admin.domain.auth.request.OAuthUserQuery;
import com.cowave.hub.admin.domain.auth.vo.OAuth2CodeVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shanhuiming
 */
public interface OAuthService {

    /**
     * gitlab回调
     */
    AccessUserDetails gitlabCallback(String tenantId, String code);

    /**
     * 获取授权服务配置
     */
    HubOAuth getOauth(String tenantId, String serverType);

    /**
     * 修改授权服务配置
     */
    void editOauth(String tenantId, HubOAuth oauth);

    /**
     * 用户列表
     */
    Page<HubOAuthUser> listUser(String tenantId, OAuthUserQuery query);

    /**
     * 应用获取授权码
     */
    OAuth2CodeVo getClientCode(OAuth2CodeRequest request);

    /**
     * 应用地址回调
     */
    void clientRedirect(String code, HttpServletResponse response) throws IOException;

    /**
     * 应用获取令牌
     */
    AccessUserDetails getClientToken(OAuth2TokenRequest request);

    /**
     * 应用刷新令牌
     */
    AccessUserDetails refreshClientToken(String refreshToken);
}
