package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import com.teamphoenix.ahub.fair.command.client.MemberServiceClient;
import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.repository.FairRepository;
import com.teamphoenix.ahub.fair.command.vo.ResponseMember;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "CommandFairService")
@Slf4j
public class FairServiceImpl implements FairService {

    private final FairRepository fairRepository;
    private final ModelMapper  modelMapper;
    private final MemberServiceClient memberServiceClient;

    @Autowired
    public FairServiceImpl(FairRepository fairRepository,
                           ModelMapper modelMapper,
                           MemberServiceClient memberServiceClient) {
        this.fairRepository = fairRepository;
        this.modelMapper = modelMapper;
        this.memberServiceClient = memberServiceClient;
    }

    // 게시글 등록 메소드
    @Transactional
    public FairDTO registFairPost(FairDTO fairInfo) {

        /* Setter를 사용하지 않고 생성자로 FairDTO -> Fair Entity 매핑 */
        Fair fair = new Fair(fairInfo.getFairTitle(),
                fairInfo.getFairContent(),
                fairInfo.getFairWritedate(),
                fairInfo.getUseAcceptance(),
                fairInfo.getMemberCode()) ;

        fairRepository.save(fair);

        fair = fairRepository.findByFairTitle(fairInfo.getFairTitle());

        FairDTO result = new FairDTO(
                fair.getFairId(),
                fair.getFairTitle(),
                fair.getFairContent(),
                fair.getFairWritedate(),
                fair.getUseAcceptance(),
                fair.getMemberCode()
        );

        ResponseMember memberInfo = memberServiceClient.getWriterInfo(result.getMemberCode());
        result.setWriterInfo(memberInfo);

        return result;
    }

    /* 게시글 수정 메소드 */
    @Transactional
    public FairDTO modifyFairPost(int postNum, FairDTO modifyInfo) {

        Fair oldPost = fairRepository.findById(postNum).orElseThrow(IllegalArgumentException::new);    // postNum에 해당하는 게시글 불러와서 영속성 컨텍스트에 스냅샷 객체로 저장
        oldPost.setFairTitle(modifyInfo.getFairTitle());
        oldPost.setFairContent(modifyInfo.getFairContent());
        oldPost.setFairWritedate(modifyInfo.getFairWritedate());

        FairDTO result = modelMapper.map(oldPost, FairDTO.class);

        // 페인 클라이언트로 정보 읽어온다
        ResponseMember memberVO = memberServiceClient.getWriterInfo(modifyInfo.getMemberCode());

        result.setWriterInfo(memberVO);

        return result;

    }

    /* 게시글 삭제 메소드 */
    @Transactional
    public void removeFairPost(int postNum) {

        fairRepository.deleteById(postNum);
    }


}
