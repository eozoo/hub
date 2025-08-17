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
import com.cowave.hub.admin.domain.rabc.HubRoleAppMenu;
import com.cowave.hub.admin.infra.rabc.mapper.HubRoleAppMenuMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shanhuiming
 */
@Repository
public class HubRoleAppMenuDao extends ServiceImpl<HubRoleAppMenuMapper, HubRoleAppMenu> {

    /**
     * 删除角色应用菜单
     */
    public void removeByAppIds(List<Integer> appIdList) {
        lambdaUpdate().in(HubRoleAppMenu::getAppId, appIdList).remove();
    }
}
