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
package com.cowave.hub.meter.domain.torna.bean;

/**
 * @author tanghc
 */
public interface Booleans {
    byte TRUE = 1;
    byte FALSE = 0;

    /**
     * 是否为true，当val为null，返回false
     * @param val 值
     * @return 返回true/false
     */
    static boolean isTrue(Byte val) {
        return isTrue(val, false);
    }

    /**
     * 是否为true
     * @param val 值
     * @param whenNull 当val为null时，返回whenNull指定的值
     * @return 返回true/false
     */
    static boolean isTrue(Byte val, boolean whenNull) {
        if (val == null) {
            return whenNull;
        }
        return val == TRUE;
    }

    static boolean isTrue(Long b) {
        return b != null && b == TRUE;
    }


    static byte toValue(Boolean b) {
        if (b == null) {
            return FALSE;
        }
        return b ? TRUE : FALSE;
    }
}
