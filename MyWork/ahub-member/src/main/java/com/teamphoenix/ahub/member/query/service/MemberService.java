package com.teamphoenix.ahub.member.query.service;

import com.teamphoenix.ahub.member.query.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    List<MemberDTO> selectAllMembers();

    MemberDTO selectByMemberCode(String memberCode);

    MemberDTO selectByMemberId(String memberId);

    MemberDTO selectMyprofile(String memberId);

    MemberDTO memberLogin(MemberDTO memberLoginInfo);

    List<String> findMemberIdList(List<Integer> findCode);
}
