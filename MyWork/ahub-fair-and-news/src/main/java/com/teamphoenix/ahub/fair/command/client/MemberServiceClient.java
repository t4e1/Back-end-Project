package com.teamphoenix.ahub.fair.command.client;

import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url="localhost:8000")
public interface MemberServiceClient {

    @GetMapping("/member/findByMemberCode/{userCode}")
    ResponseMember getWriterInfo(@PathVariable("userCode") int memberCode);

}
