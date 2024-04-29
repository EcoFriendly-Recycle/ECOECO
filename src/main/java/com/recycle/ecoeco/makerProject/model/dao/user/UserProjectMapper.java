package com.recycle.ecoeco.makerProject.model.dao.user;

import com.recycle.ecoeco.makerProject.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserProjectMapper {
    int registProjectInfo(ProjectDTO projectDTO);
    int registMakerInfo(MakerDTO makerDTO);

    int registRewardInfo(RewardDTO rewardDTO);
    List<RewardDTO> getAllRewards(); //리워드 조회
    int deleteReward(int rewardNo); // 리워드 삭제

    int registStoryInfo(StoryDTO storyDTO);//스토리매퍼

    int registStoryRepImage(StoryRepImgDTO storyRepImgDTO);//스토리 대표이미지 매퍼

    int countRewardByRewardNo(int rewardNo);//리워드 삭제 테스트

}
