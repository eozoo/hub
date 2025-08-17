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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.hub.admin.domain.rabc.HubOAuthAppMenu;
import com.cowave.hub.admin.domain.rabc.enums.EnableStatus;
import com.cowave.hub.admin.infra.rabc.mapper.HubOAuthAppMenuMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shanhuiming
 */
@Repository
public class HubOAuthAppMenuDao extends ServiceImpl<HubOAuthAppMenuMapper, HubOAuthAppMenu> {

    /**
     * 删除应用菜单
     */
    public void removeByAppIds(List<Integer> appIdList) {
        lambdaUpdate().in(HubOAuthAppMenu::getAppId, appIdList).remove();
    }

    /**
     * 应用菜单列表
     */
    public List<HubOAuthAppMenu> listMenus(Integer appId, String menuName, EnableStatus menuStatus) {
        return lambdaQuery()
                .eq(HubOAuthAppMenu::getAppId, appId)
                .eq(menuStatus != null, HubOAuthAppMenu::getMenuStatus, menuStatus)
                .like(StringUtils.isNotBlank(menuName), HubOAuthAppMenu::getMenuName, menuName)
                .orderByAsc(HubOAuthAppMenu::getParentId, HubOAuthAppMenu::getMenuOrder)
                .list();
    }
}
