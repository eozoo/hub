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
package com.cowave.hub.meter.infra.build;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.hub.meter.domain.build.BuildFolder;
import com.cowave.hub.meter.domain.constants.Visibility;
import com.cowave.hub.meter.infra.build.mapper.BuildFolderMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import static com.cowave.hub.meter.domain.constants.Visibility.PUBLIC;

/**
 * @author shanhuiming
 */
@Repository
public class BuildFolderDao extends ServiceImpl<BuildFolderMapper, BuildFolder> {

    /**
     * 列表
     */
    public List<BuildFolder> listTree(Collection<Integer> folderIdList) {
        return lambdaQuery().and(wrapper -> {
                    if (CollectionUtils.isNotEmpty(folderIdList)) {
                        wrapper.in(BuildFolder::getFolderId, folderIdList).or();
                    }
                    wrapper.eq(BuildFolder::getVisibility, PUBLIC);
                })
                .orderByAsc(BuildFolder::getParentId)
                .orderByAsc(BuildFolder::getFolderOrder)
                .list();
    }

    /**
     * 修改名称
     */
    public void updateNameById(Integer folderId, String folderName) {
        lambdaUpdate()
                .eq(BuildFolder::getFolderId, folderId)
                .set(BuildFolder::getFolderName, folderName)
                .update();
    }

    /**
     * 修改访问限制
     */
    public void updateVisibilityById(List<Integer> folderIdList, Visibility visibility) {
        lambdaUpdate()
                .in(BuildFolder::getFolderId, folderIdList)
                .set(BuildFolder::getVisibility, visibility)
                .update();
    }

    /**
     * 修改创建人
     */
    public void updateCreatorById(Integer folderId, String userCode, String userName) {
        lambdaUpdate()
                .eq(BuildFolder::getFolderId, folderId)
                .set(BuildFolder::getOwnerCode, userCode)
                .set(BuildFolder::getOwnerName, userName)
                .update();
    }

    /**
     * 修改创建人
     */
    public void transferCreatorById(List<Integer> folderIdList, String preUserCode, String userCode, String userName) {
        lambdaUpdate()
                .in(BuildFolder::getFolderId, folderIdList)
                .eq(BuildFolder::getOwnerCode, preUserCode)
                .set(BuildFolder::getOwnerCode, userCode)
                .set(BuildFolder::getOwnerName, userName)
                .update();
    }
}
