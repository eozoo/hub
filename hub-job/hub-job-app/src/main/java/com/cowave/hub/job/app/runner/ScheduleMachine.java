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
package com.cowave.hub.job.app.runner;

import com.alipay.sofa.jraft.Closure;
import com.alipay.sofa.jraft.Iterator;
import com.alipay.sofa.jraft.StateMachine;
import com.alipay.sofa.jraft.Status;
import com.alipay.sofa.jraft.conf.Configuration;
import com.alipay.sofa.jraft.entity.LeaderChangeContext;
import com.alipay.sofa.jraft.error.RaftException;
import com.alipay.sofa.jraft.storage.snapshot.SnapshotReader;
import com.alipay.sofa.jraft.storage.snapshot.SnapshotWriter;
import com.cowave.hub.job.infra.schedule.ScheduleContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xuxueli/shanhuiming
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduleMachine implements StateMachine {

    private final ScheduleContext scheduleContext;

    @Override
    public void onLeaderStart(long l) {
        scheduleContext.start();

    }

    @Override
    public void onLeaderStop(Status status) {
        scheduleContext.stop();
    }

    @Override
    public void onApply(Iterator iterator) {
        // no task
    }

    @Override
    public void onShutdown() {

    }

    @Override
    public void onSnapshotSave(SnapshotWriter snapshotWriter, Closure closure) {

    }

    @Override
    public boolean onSnapshotLoad(SnapshotReader snapshotReader) {
        return false;
    }

    @Override
    public void onError(RaftException e) {

    }

    @Override
    public void onConfigurationCommitted(Configuration configuration) {

    }

    @Override
    public void onStopFollowing(LeaderChangeContext leaderChangeContext) {

    }

    @Override
    public void onStartFollowing(LeaderChangeContext leaderChangeContext) {

    }
}
