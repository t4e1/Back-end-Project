package com.teamphoenix.fairandnews.fair;

import com.teamphoenix.fairandnews.fair.common.Fair;
import com.teamphoenix.fairandnews.fair.common.FairDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FairMapper {

    FairDTO getFairPost(int postNum);

    List<FairDTO> selectPostsBySearchCategory(FairDTO searchInfo) ;
}
