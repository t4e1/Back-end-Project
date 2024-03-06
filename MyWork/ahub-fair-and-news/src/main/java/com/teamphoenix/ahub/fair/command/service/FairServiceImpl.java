package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import com.teamphoenix.ahub.fair.command.repository.FairRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service(value = "CommandFairService")
@Slf4j
public class FairServiceImpl implements FairService{

    private final FairRepository fairRepository;
    private final ModelMapper  modelMapper;
    @Autowired
    public FairServiceImpl(FairRepository fairRepository, ModelMapper modelMapper) {
        this.fairRepository = fairRepository;
        this.modelMapper = modelMapper;
    }

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

        return result;
    }

    /* 게시글 수정 메소드 */
    @Transactional
    public void modifyFairPost(int postNum, FairDTO modifyInfo) {

        Fair oldPost = fairRepository.findById(postNum).orElseThrow(IllegalArgumentException::new);    // postNum에 해당하는 게시글 불러와서 영속성 컨텍스트에 스냅샷 객체로 저장
        oldPost.setFairTitle(modifyInfo.getFairTitle());
        oldPost.setFairContent(modifyInfo.getFairContent());
        oldPost.setFairWritedate(modifyInfo.getFairWritedate());

        /* @Transactional 에 의해 메소드 종료 시 자동으로 flush & commit */
    }

    /* 게시글 삭제 메소드 */
    public void removeFairPost(int postNum) {

        fairRepository.deleteById(postNum);
    }
}
