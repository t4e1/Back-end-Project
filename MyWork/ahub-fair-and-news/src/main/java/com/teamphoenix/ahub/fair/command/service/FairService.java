package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;
import com.teamphoenix.ahub.fair.command.entity.Fair;
import com.teamphoenix.ahub.fair.command.repository.FairRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CommandFairService")
@Log4j2
public class FairService {

    private final FairRepository fairRepository;
    private final ModelMapper  modelMapper;
    @Autowired
    public FairService(FairRepository fairRepository, ModelMapper modelMapper) {
        this.fairRepository = fairRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registFairPost(FairDTO fairInfo) {

        /* Setter를 사용하지 않고 생성자로 FairDTO -> Fair Entity 매핑 */
        Fair fair = new Fair(fairInfo.getFairTitle(),
                fairInfo.getFairContent(),
                fairInfo.getFairWritedate(),
                fairInfo.getUseAcceptance(),
                fairInfo.getMemberCode());


        log.info("fair 엔터티 확인 : {}", fair);
        fairRepository.save(fair);

    }

    @Transactional
    public void modifyFairPost(int postNum, FairDTO modifyInfo) {

        Fair fair = new Fair(modifyInfo.getFairTitle(),
                modifyInfo.getFairContent(),
                modifyInfo.getFairWritedate(),
                modifyInfo.getUseAcceptance(),
                modifyInfo.getMemberCode());

        /* repository 관련 기능 추가 필요 */
    }
}
