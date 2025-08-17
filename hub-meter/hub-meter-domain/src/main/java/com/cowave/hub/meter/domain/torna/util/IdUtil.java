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
package com.cowave.hub.meter.domain.torna.util;

import lombok.extern.slf4j.Slf4j;
import org.hashids.Hashids;

/**
 * @author tanghc
 */
@Slf4j
public class IdUtil {

    private static final Hashids hashids = new Hashids("@r9#8e.N$z>09=dG", 8);

    public static final long MAX = 9007199254740992L;

    public static String encode(Long id) {
        if (id == null || id == 0) {
            return "";
        }
        return hashids.encode(id);
    }

    /**
     * decode hashid
     * @param id hashid
     * @return return true id, otherwise return null
     */
    public static Long decode(String id) {
        if (id == null || "".equals(id)) {
            return null;
        }
        try {
            long[] arr = hashids.decode(id);
            if (arr == null || arr.length == 0) {
                return null;
            }
            return arr[0];
        } catch (Exception e) {
            log.error("id decode error, id:{}", id, e);
            return null;
        }
    }

}
