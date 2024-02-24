package com.teamphoenix.fairandnews.fair;

import com.teamphoenix.fairandnews.fair.common.Fair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FairMapper {

    Fair getFairPost(int postNum);
}
