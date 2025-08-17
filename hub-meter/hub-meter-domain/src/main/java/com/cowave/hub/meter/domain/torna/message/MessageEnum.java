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
package com.cowave.hub.meter.domain.torna.message;

/**
 *
 * @author tanghc
 */
public enum MessageEnum {
    DOC_UPDATE("message.doc.update"),
    DOC_UPDATE_REMARK("message.doc.update-remark"),
    DOC_DELETE("message.doc.delete"),
    PUSH_ERROR("message.doc.push"),
    PUSH_DOC_SUCCESS("message.custom"),

    ;
    private final MessageMeta messageMeta;

    MessageEnum(String key) {
        this.messageMeta = new MessageMeta(key);
    }

    public MessageMeta getMessageMeta() {
        return messageMeta;
    }

}
