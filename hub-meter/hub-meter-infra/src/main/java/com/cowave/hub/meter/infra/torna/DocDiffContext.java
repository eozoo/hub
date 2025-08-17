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
package com.cowave.hub.meter.infra.torna;

import com.cowave.hub.meter.domain.torna.dto.DocDiffDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author thc
 */
public class DocDiffContext {

    private static final Queue<DocDiffDTO> QUEUE = new LinkedBlockingQueue<>();


    public static void addQueue(DocDiffDTO docDiff) {
        QUEUE.offer(docDiff);
    }

    public static List<DocDiffDTO> poll(int limit) {
        if (QUEUE.isEmpty()) {
            return Collections.emptyList();
        }
        int size = Math.min(QUEUE.size(), limit);
        List<DocDiffDTO> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(QUEUE.poll());
        }
        return list;
    }

}
