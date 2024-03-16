package com.teamphoenix.ahub.member.query.mapper;

import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectAllMembers();

    MemberDTO selectByMemberCode(int memberCode);

    MemberDTO selectByMemberId(String memberId);

    MemberDTO selectMyprofile(String memberId);

    MemberDTO memberLogin(Map<String, String> memberLogin);

    // 설명. Feign 메소드에서 요구하는 메소드
    String findMemberId(int memberCode);
}
