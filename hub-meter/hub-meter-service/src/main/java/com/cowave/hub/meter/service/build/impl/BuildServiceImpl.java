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
package com.cowave.hub.meter.service.build.impl;

import com.cowave.hub.meter.core.build.BuildTask;
import com.cowave.hub.meter.infra.build.mapper.dto.BuildDtoMapper;
import com.cowave.hub.meter.service.build.BuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @author shanhuiming
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BuildServiceImpl implements BuildService {

    private final BuildDtoMapper buildDtoMapper;

    @Override
    public void build() {
        String buildName = "test";
        Long buildIndex = buildDtoMapper.nextIndexOfBuild(1);
        File workHome = new File(System.getProperty("user.dir")
                + File.separator + "workHome" + File.separator + buildName + "@" + buildIndex);
        if(!workHome.mkdirs()){
            throw new RuntimeException("dir failed");
        }

        new BuildTask(workHome).run();
    }
}
