package com.teamphoenix.ahub.fair.command.service;

import com.teamphoenix.ahub.fair.command.dto.FairDTO;

public interface FairService {
    void removeFairPost(int postNum);

    FairDTO modifyFairPost(int postNum, FairDTO modifyInfo);

    FairDTO registFairPost(FairDTO newFairPost);
}
