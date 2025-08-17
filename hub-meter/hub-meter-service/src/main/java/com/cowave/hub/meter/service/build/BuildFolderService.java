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
package com.cowave.hub.meter.service.build;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.hub.meter.domain.build.BuildFolder;
import com.cowave.hub.meter.domain.build.BuildFolderMember;
import com.cowave.hub.meter.domain.build.request.*;

import java.util.List;

/**
 * @author shanhuiming
 */
public interface BuildFolderService {

    /**
     * 目录结构
     */
    List<Tree<Integer>> tree();

    /**
     * 目录拖拽
     */
    void drag(FolderDrag folderDrag);

    /**
     * 新增
     */
    void create(BuildFolder buildFolder);

    /**
     * 删除
     */
    void delete(Integer folderId);

    /**
     * 修改目录名称
     */
    void rename(FolderRename folderRename);

    /**
     * 修改目录访问限制
     */
    void updateVisibility(VisibilityUpdate visibilityUpdate);

    /**
     * 目录成员选项
     */
    Page<BuildFolderMember> listFolderMembers(FolderMemberQuery query);

    /**
     * 目录成员列表
     */
    List<BuildFolderMember> listFolderMembers(Integer folderId);

    /**
     * 追加目录成员
     */
    void addMembers(FolderMemberRequest memberRequest);

    /**
     * 修改成员角色
     */
    void updateMemberRole(FolderMemberUpdate update);

    /**
     * 转让目录
     */
    void transferFolderMember(FolderMemberTransfer transfer);

    /**
     * 删除目录成员
     */
    void deleteMember(Integer folderId, String userCode);
}
