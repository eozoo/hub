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
package com.cowave.hub.meter.service.env.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cowave.zoo.http.client.asserts.HttpAsserts;
import com.cowave.hub.meter.domain.env.EnvCredential;
import com.cowave.hub.meter.domain.env.request.CredentialQuery;
import com.cowave.hub.meter.infra.env.EnvCredentialDao;
import com.cowave.hub.meter.service.env.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cowave.zoo.http.client.constants.HttpCode.BAD_REQUEST;
import static com.cowave.zoo.http.client.constants.HttpCode.NOT_FOUND;

/**
 * @author shanhuiming
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CredentialServiceImpl implements CredentialService {

    private final EnvCredentialDao envCredentialDao;

    @Override
    public Page<EnvCredential> list(CredentialQuery query) {
        return envCredentialDao.pageList(query);
    }

    @Override
    public EnvCredential info(Integer credentialId) {
        return envCredentialDao.getById(credentialId);
    }

    @Override
    public void create(EnvCredential credential) {
        envCredentialDao.save(credential);
    }

    @Override
    public void delete(List<Integer> credentialIds) {
        envCredentialDao.removeBatchByIds(credentialIds);
    }

    @Override
    public void edit(EnvCredential credential) {
        HttpAsserts.notNull(credential.getCredentialId(), BAD_REQUEST, "凭据id不能为空");

        EnvCredential preCredential = envCredentialDao.getById(credential.getCredentialId());
        HttpAsserts.notNull(preCredential, NOT_FOUND, "不存在的凭据");

        envCredentialDao.updateById(credential);
    }
}
