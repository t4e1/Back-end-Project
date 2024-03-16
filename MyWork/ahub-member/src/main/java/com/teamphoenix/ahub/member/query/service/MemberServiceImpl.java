package com.teamphoenix.ahub.member.query.service;

import com.teamphoenix.ahub.member.query.client.PostAndReplyServiceClient;
import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import com.teamphoenix.ahub.member.query.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("MemberService2")
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final PostAndReplyServiceClient postAndReplyServiceClient;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, PostAndReplyServiceClient postAndReplyServiceClient) {
        this.memberMapper = memberMapper;
        this.postAndReplyServiceClient = postAndReplyServiceClient;
    }

    public List<MemberDTO> selectAllMembers(){
        List<MemberDTO> members = memberMapper.selectAllMembers();
        System.out.println("전체 회원 목록");
        members.forEach(System.out::println);

        return members;
    }

    public MemberDTO selectByMemberCode(String inputMemberCode){
        int intMemberCode = Integer.valueOf(inputMemberCode);

        MemberDTO member = memberMapper.selectByMemberCode(intMemberCode);

        return member;
    }

    public MemberDTO selectByMemberId(String inputMemberId){

        MemberDTO member = memberMapper.selectByMemberId(inputMemberId);

        return member;
    }

    public int getMemberCode(String currentMemberId){
        int memberCode = 0;

        return memberCode;
    }

    public MemberDTO selectMyprofile(String currentMemberId){

        MemberDTO member = memberMapper.selectMyprofile(currentMemberId);

        return member;
    }

    /* 설명. @requestBody 방식으로 가져온 data */
    public MemberDTO memberLogin(MemberDTO memberLoginInfo) {
        String memberId = memberLoginInfo.getMemberId();
        String memberPwd = memberLoginInfo.getMemberPwd();

        Map<String, String> memberLogin = new HashMap<>();
        memberLogin.put("memberId", memberId);
        memberLogin.put("memberPwd", memberPwd);

        MemberDTO member = memberMapper.memberLogin(memberLogin);

        return member;
    }

    // 설명. FeignClient 용으로 필요한 메소드
    public List<String> findMemberIdList(List<Integer> findCode) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < findCode.size(); i++) {
            result.add(memberMapper.findMemberId(findCode.get(i)));
        }

        return result;
    }
}