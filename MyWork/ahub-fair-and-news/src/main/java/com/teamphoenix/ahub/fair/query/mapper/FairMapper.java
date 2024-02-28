package com.teamphoenix.ahub.fair.query.mapper;

import com.teamphoenix.ahub.fair.query.dto.FairDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FairMapper {

    FairDTO getFairPost(int postNum);

    List<FairDTO> searchPostsByCondition(FairDTO searchInfo) ;
}
