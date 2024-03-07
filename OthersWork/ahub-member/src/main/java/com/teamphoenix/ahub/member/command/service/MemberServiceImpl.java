package com.teamphoenix.ahub.member.command.service;

import com.teamphoenix.ahub.member.command.aggregate.MemberInfo;
import com.teamphoenix.ahub.member.command.dto.MemberDTO;
import com.teamphoenix.ahub.member.command.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                             ModelMapper modelMapper,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /* 회원 가입 */
    @Transactional
    @Override
    public void registMember(MemberDTO newMemberInfo) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MemberInfo memberInfo = modelMapper.map(newMemberInfo, MemberInfo.class);

        // 비밀번호 암호화
        memberInfo.setMemberPwd(bCryptPasswordEncoder.encode(newMemberInfo.getMemberPwd()));
        System.out.println("memberInfo = " + memberInfo);
        memberRepository.save(memberInfo);
    }

    /* memberId를 통해 해당 회원의 memberCode를 가져오는 코드 */
    @Transactional
    public int getMemberCode(String memberId){
        int memberCode = memberRepository.findByMemberId(memberId).getMemberCode();

        return memberCode;
    }

    /* 회원 정보 수정 */
    @Transactional
    @Override
    public int modifyMember(String memberId, MemberDTO modifyMember) {

        int memberCode = getMemberCode(memberId);

        MemberInfo modifyValue = memberRepository.findById(memberCode).orElseThrow(IllegalAccessError::new);
        modifyValue.setMemberName(modifyMember.getMemberName());
        modifyValue.setMemberPwd(modifyMember.getMemberPwd());
        modifyValue.setMemberEmail(modifyMember.getMemberEmail());
        modifyValue.setMemberAddr(modifyMember.getMemberAddr());
        modifyValue.setMemberPhone(modifyMember.getMemberPhone());

        return memberCode;
    }

    /* 회원 탈퇴 기능 */
    @Override
    public void removeMember(String memberId) {
        int memberCode = getMemberCode(memberId);

        memberRepository.deleteById(memberCode);
    }

    /* 로그인 기능 구현 중 필요한 select 문 */
    @Override
    public MemberDTO searchMember(String memberId) {

        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);
        MemberDTO memberDTO = modelMapper.map(memberInfo, MemberDTO.class);

        return memberDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        MemberInfo memberInfo = memberRepository.findByMemberId(memberId);

        if (memberInfo == null) {
            throw new UsernameNotFoundException(memberId + " 유저는 존재하지 않습니다.");
        }

        // 다시 Authentication Filter 로 돌아간다.
        return new User(memberInfo.getMemberId(), memberInfo.getMemberPwd(),
                true, true, true, true,
                new ArrayList<>());
    }
}
