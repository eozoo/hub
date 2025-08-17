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
package com.cowave.hub.meter.domain.torna.dto;

import com.cowave.hub.meter.domain.torna.bean.User;
import com.cowave.hub.meter.domain.torna.enums.ModifySourceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author thc
 */
@Data
@AllArgsConstructor
public class DocDiffDTO {

    private String md5Old;
    private String md5New;
    private LocalDateTime modifyTime;

    private User user;

    private ModifySourceEnum modifySourceEnum;

}
