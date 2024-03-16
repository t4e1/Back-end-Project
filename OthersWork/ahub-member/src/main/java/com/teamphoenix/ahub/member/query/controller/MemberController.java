package com.teamphoenix.ahub.member.query.controller;

import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import com.teamphoenix.ahub.member.query.service.MemberService;
import com.teamphoenix.ahub.member.query.vo.RequestMember;
import com.teamphoenix.ahub.member.query.vo.ResponseMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/findAllMembers")
    public List<MemberDTO> findAllMembers() {
        /* 프론트 작업 후 사용자 입력을 받아오는 코드 추가 */

        return memberService.selectAllMembers();
    }

    @GetMapping("/findByMemberCode/{memberCode}")
    public MemberDTO findByMemberCode(@PathVariable("memberCode") int memberCode) {

        return memberService.selectByMemberCode(memberCode);
    }

    @GetMapping("/findByMemberId/{memberId}")
    public MemberDTO findByMemberId(@PathVariable("memberId") String memberId) {

        return memberService.selectByMemberId(memberId);
    }

    @PostMapping("/findMyprofile")
    public ResponseEntity<ResponseMember> selectMyprofile(@RequestBody RequestMember currentMemberId) {
        MemberDTO currentMember = modelMapper.map(currentMemberId, MemberDTO.class);

        MemberDTO myProfile = memberService.selectMyprofile(currentMember);

        ResponseMember responseMember = new ResponseMember();
        responseMember.setMemberId(myProfile.getMemberId());
        responseMember.setMemberName(myProfile.getMemberName());
        responseMember.setMemberAddr(myProfile.getMemberAddr());
        responseMember.setMemberEmail(myProfile.getMemberEmail());
        responseMember.setMemberPhone(myProfile.getMemberPhone());
        responseMember.setRestrictStartDate(myProfile.getRestrictStartDate());

        return ResponseEntity.status(HttpStatus.OK).body(responseMember);
    }


    /* 설명. 회원 로그인에 security 적용하기 */
    @PostMapping("/findLogin")
    public ResponseEntity<ResponseMember> memberLogin(@RequestBody RequestMember login) {
        MemberDTO memberLoginInfo = modelMapper.map(login, MemberDTO.class);

        MemberDTO loginResult = memberService.memberLogin(memberLoginInfo);

        ResponseMember responseMember = new ResponseMember();
        responseMember.setMemberId(login.getMemberId());
        responseMember.setMemberName(loginResult.getMemberName());

        return ResponseEntity.status(HttpStatus.OK).body(responseMember);
    }

    /* member_id list 반환하는 메소드 (Feign Client용) */
    @PostMapping("/request-list")
    public List<String> getWriterList(@RequestBody List<String> writerCodes) {

        List<Integer> findCode = new ArrayList<>();

        for (String code : writerCodes) {
            int condition = Integer.parseInt(code);
            findCode.add(condition);
        }

        return memberService.findMemberIdList(findCode);
    }

    @GetMapping("/request-code/{userId}")
    public int getWriterCode(@PathVariable("userId") String memberId) {

        return memberService.findMemberCode(memberId);
    }

}
