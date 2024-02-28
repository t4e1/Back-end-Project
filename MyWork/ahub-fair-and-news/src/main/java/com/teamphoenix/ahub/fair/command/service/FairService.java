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

        log.info("ModelMapper 동작 확인 : {}", modelMapper.map(fairInfo, Fair.class));
        fairRepository.save(modelMapper.map(fairInfo, Fair.class));

    }
}
