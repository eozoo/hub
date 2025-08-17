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
package com.cowave.hub.meter.infra.torna.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cowave.hub.meter.domain.torna.entity.Prop;
import com.cowave.hub.meter.domain.torna.enums.PropTypeEnum;
import com.cowave.hub.meter.infra.torna.dao.mapper.PropMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PropDao extends ServiceImpl<PropMapper, Prop> {

    public Map<String, String> getDocProps(Long docId) {
        if (docId == null) {
            return Collections.emptyMap();
        }
        return getProps(docId, PropTypeEnum.DOC_INFO_PROP.getType());
    }

    public Map<String, String> getProps(Long refId, byte type) {
        return this.listProps(refId, type).stream().collect(Collectors.toMap(Prop::getName, Prop::getVal));
    }

    public List<Prop> listProps(Long refId, byte type) {
        if (refId == null) {
            return Collections.emptyList();
        }
        return lambdaQuery()
                .eq(Prop::getRefId, refId)
                .eq(Prop::getType, type)
                .list();
    }

    public void saveProps(Map<String, ?> props, Long refId, PropTypeEnum type) {
        saveProps(props, refId, type.getType());
    }

    public void saveProps(Map<String, ?> props, Long refId, byte type) {
        if (props == null || props.isEmpty()) {
            return;
        }
        List<Prop> tobeSave = props.entrySet().stream().map(
                entry -> {
                    Prop prop = new Prop();
                    prop.setRefId(refId);
                    prop.setType(type);
                    prop.setName(entry.getKey());
                    prop.setVal(String.valueOf(entry.getValue()));
                    return prop;
                }).collect(Collectors.toList());
        saveBatch(tobeSave);
    }
}
