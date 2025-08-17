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
package com.cowave.hub.meter.infra.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.zoo.tools.Collections;
import com.cowave.zoo.tools.Converts;
import com.cowave.hub.meter.domain.torna.bean.Booleans;
import com.cowave.hub.meter.domain.torna.dto.EnumItemDTO;
import com.cowave.hub.meter.domain.api.ApiEnumItem;
import com.cowave.hub.meter.infra.api.dao.mapper.ApiEnumItemMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApiEnumItemDao extends ServiceImpl<ApiEnumItemMapper, ApiEnumItem> {

    public void replaceEnumItem(long enumId, List<EnumItemDTO> items) {
        // 删除枚举子项
        lambdaUpdate().eq(ApiEnumItem::getEnumId, enumId).remove();
        // 批量保存
        this.saveBatch(enumId, items);
    }

    private void saveBatch(long enumId, List<EnumItemDTO> itemDTOList) {
        List<ApiEnumItem> apiEnumItemList = itemDTOList.stream().map(
                enumItemDTO -> {
                    ApiEnumItem apiEnumItem = Converts.copyProperties(enumItemDTO, ApiEnumItem.class);
                    apiEnumItem.setEnumId(enumId);
                    apiEnumItem.setIsDeleted(Booleans.FALSE);
                    return apiEnumItem;
                }).collect(Collectors.toList());
        this.saveBatch(apiEnumItemList);
    }

    public List<EnumItemDTO> listItems(long enumId) {
        List<ApiEnumItem> itemList = lambdaQuery()
                .eq(ApiEnumItem::getEnumId, enumId)
                .orderByAsc(ApiEnumItem::getId)
                .list();
        return Collections.convertToList(itemList, EnumItemDTO.class);
    }
}
