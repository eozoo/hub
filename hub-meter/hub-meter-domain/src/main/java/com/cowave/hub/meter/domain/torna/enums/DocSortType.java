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
package com.cowave.hub.meter.domain.torna.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author thc
 */
@AllArgsConstructor
@Getter
public enum DocSortType {
    BY_ORDER("by_order"),
    BY_NAME("by_name"),
    BY_URL("by_url"),

    ;
    private final String type;

    public static DocSortType of(String type) {
        if (type == null) {
            return BY_ORDER;
        }
        for (DocSortType value : DocSortType.values()) {
            if (Objects.equals(type, value.getType())) {
                return value;
            }
        }
        return BY_ORDER;
    }
}
