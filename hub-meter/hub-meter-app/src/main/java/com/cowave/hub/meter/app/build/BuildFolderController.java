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
package com.cowave.hub.meter.app.build;

import cn.hutool.core.lang.tree.Tree;
import com.cowave.hub.meter.domain.build.request.*;
import com.cowave.zoo.http.client.response.Response;
import com.cowave.hub.meter.domain.build.BuildFolder;
import com.cowave.hub.meter.domain.build.BuildFolderMember;
import com.cowave.hub.meter.service.build.BuildFolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 构建目录
 *
 * @author shanhuiming
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/build/folder")
public class BuildFolderController {

    private final BuildFolderService buildFolderService;

    /**
     * 目录结构
     */
    @GetMapping
    public Response<List<Tree<Integer>>> tree() {
        return Response.success(buildFolderService.tree());
    }

    /**
     * 目录拖拽
     */
    @PatchMapping("/drag")
    public Response<Void> drag(@Validated @RequestBody FolderDrag folderDrag) throws Exception {
        return Response.success(() -> buildFolderService.drag(folderDrag));
    }

    /**
     * 新增
     */
    @PostMapping
    public Response<Void> create(@Validated @RequestBody BuildFolder buildFolder) throws Exception {
        return Response.success(() -> buildFolderService.create(buildFolder));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{folderId}")
    public Response<Void> delete(@PathVariable Integer folderId) throws Exception {
        return Response.success(() -> buildFolderService.delete(folderId));
    }

    /**
     * 修改目录名称
     */
    @PatchMapping("/name")
    public Response<Void> rename(@Validated @RequestBody FolderRename folderRename) throws Exception {
        return Response.success(() -> buildFolderService.rename(folderRename));
    }

    /**
     * 修改访问限制
     */
    @PatchMapping("/visibility")
    public Response<Void> updateVisibility(@Validated @RequestBody VisibilityUpdate visibilityUpdate) throws Exception {
        return Response.success(() -> buildFolderService.updateVisibility(visibilityUpdate));
    }

    /**
     * 目录成员选项
     */
    @GetMapping("/members")
    public Response<Response.Page<BuildFolderMember>> listFolderMembers(FolderMemberQuery query) {
        return Response.page(buildFolderService.listFolderMembers(query));
    }

    /**
     * 目录成员列表
     */
    @GetMapping("/members/{folderId}")
    public Response<Response.Page<BuildFolderMember>> listFolderMembers(@PathVariable Integer folderId) {
        return Response.page(buildFolderService.listFolderMembers(folderId));
    }

    /**
     * 追加目录成员
     */
    @PostMapping("/members")
    public Response<Void> addMembers(@Validated @RequestBody FolderMemberRequest memberRequest) throws Exception {
        return Response.success(() -> buildFolderService.addMembers(memberRequest));
    }

    /**
     * 修改成员角色
     */
    @PatchMapping("/members/role")
    public Response<Void> updateMemberRole(@Validated @RequestBody FolderMemberUpdate update) throws Exception {
        return Response.success(() -> buildFolderService.updateMemberRole(update));
    }

    /**
     * 转让目录
     */
    @PatchMapping("/members/transfer")
    public Response<Void> transferFolderMember(@Validated @RequestBody FolderMemberTransfer transfer) throws Exception {
        return Response.success(() -> buildFolderService.transferFolderMember(transfer));
    }

    /**
     * 删除目录成员
     */
    @DeleteMapping("/members")
    public Response<Void> deleteMember(Integer folderId, String userCode) throws Exception {
        return Response.success(() -> buildFolderService.deleteMember(folderId, userCode));
    }
}
