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
package com.cowave.hub.meter.app.env;

import com.cowave.zoo.http.client.response.Response;
import com.cowave.hub.meter.domain.env.EnvCredential;
import com.cowave.hub.meter.domain.env.request.CredentialQuery;
import com.cowave.hub.meter.service.env.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 凭据
 *
 * @author shanhuiming
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/credential")
public class CredentialController {

    private final CredentialService credentialService;

    /**
	 * 列表
	 */
	@GetMapping
	public Response<Response.Page<EnvCredential>> list(CredentialQuery query) {
		return Response.page(credentialService.list(query));
	}

    /**
	 * 详情
	 */
	@GetMapping("/{credentialId}")
	public Response<EnvCredential> info(@PathVariable Integer credentialId) {
		return Response.success(credentialService.info(credentialId));
	}

    /**
     * 新增
     */
    @PostMapping
    public Response<Void> create(@Validated @RequestBody EnvCredential credential) throws Exception {
        return Response.success(() -> credentialService.create(credential));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{credentialIds}")
    public Response<Void> delete(@PathVariable List<Integer> credentialIds) throws Exception {
        return Response.success(() -> credentialService.delete(credentialIds));
    }

    /**
     * 修改
     */
    @PatchMapping
    public Response<Void> edit(@Validated @RequestBody EnvCredential credential) throws Exception {
        return Response.success(() -> credentialService.edit(credential));
    }
}
