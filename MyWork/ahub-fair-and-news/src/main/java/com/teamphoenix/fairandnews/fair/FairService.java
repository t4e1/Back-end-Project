package com.teamphoenix.fairandnews.fair;

import com.teamphoenix.fairandnews.fair.common.Fair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FairService {

    private final FairMapper fairMapper;

    @Autowired
    public FairService(FairMapper fairMapper) {
        this.fairMapper = fairMapper;
    }

    public Fair getFairPost(Map<String, String> fairId) {

        int postNum = Integer.valueOf(fairId.get("fairId"));
        // fairId 의 밸류가 넘어와서 getPostNum 에 저장됨
        List<Fair> test = new ArrayList<>();
        test.add(fairMapper.getFairPost(postNum));
        System.out.println("test = " + test);

        return fairMapper.getFairPost(postNum);
    }
}
