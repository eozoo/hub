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
package com.cowave.hub.meter.domain.build.request;

import com.cowave.zoo.tools.Collections;
import com.cowave.hub.meter.domain.build.BuildFolder;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shanhuiming
 */
@Data
public class FolderDrag {

    /**
     * 拽入目录的id
     */
    private Integer parentId;

    /**
     * 被拽目录的id
     */
    private Integer folderId;

    /**
     * 拽入目录的子目录id
     */
    private List<Integer> childrenIds;

    public List<BuildFolder> getFolderList() {
        AtomicInteger order = new AtomicInteger(0);
        return Collections.copyToList(childrenIds, id ->
                BuildFolder.builder().folderId(id).parentId(parentId).folderOrder(order.incrementAndGet()).build());
    }
}
