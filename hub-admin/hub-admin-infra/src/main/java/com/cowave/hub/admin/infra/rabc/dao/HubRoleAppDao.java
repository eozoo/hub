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
import com.cowave.hub.admin.domain.rabc.HubRoleApp;
import com.cowave.hub.admin.infra.rabc.mapper.HubRoleAppMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shanhuiming
 */
@Repository
public class HubRoleAppDao extends ServiceImpl<HubRoleAppMapper, HubRoleApp> {

    /**
     * 删除角色应用
     */
    public void removeByRoleId(Integer roleId) {
        lambdaUpdate().eq(HubRoleApp::getRoleId, roleId).remove();
    }

    /**
     * 获取角色应用
     */
    public List<Integer> listByRoleId(Integer roleId) {
        return lambdaQuery().eq(HubRoleApp::getRoleId, roleId)
                .select(HubRoleApp::getAppId)
                .list().stream().map(HubRoleApp::getAppId).toList();
    }

    /**
     * 获取角色应用
     */
    public List<HubRoleApp> listByRoleIdList(List<Integer> roleIdList) {
        return lambdaQuery().in(HubRoleApp::getRoleId, roleIdList).list();
    }

    /**
     * 删除角色应用
     */
    public void removeByAppIds(List<Integer> appIdList) {
        lambdaUpdate().in(HubRoleApp::getAppId, appIdList).remove();
    }
}
