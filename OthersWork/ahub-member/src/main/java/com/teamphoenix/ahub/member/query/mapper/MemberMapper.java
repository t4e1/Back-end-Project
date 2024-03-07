package com.teamphoenix.ahub.member.query.mapper;

import com.teamphoenix.ahub.member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectAllMembers();

    MemberDTO selectByMemberCode(int memberCode);

    MemberDTO selectByMemberId(Map<String, String> memberId);

    MemberDTO selectMyprofile(Map<String, String> memberId);

    MemberDTO memberLogin(Map<String, String> memberLogin);
}
