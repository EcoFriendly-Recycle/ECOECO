package com.recycle.ecoeco.makerProject.service.user;

import com.recycle.ecoeco.makerProject.model.dao.user.UserProjectMapper;
import com.recycle.ecoeco.makerProject.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserProjectService {


    private final UserProjectMapper userProjectMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;


    @Autowired
    public UserProjectService(UserProjectMapper userProjectMapper) {
        this.userProjectMapper = userProjectMapper;
    }


    public int registProjectInfo(ProjectDTO projectDTO) {
        int result = userProjectMapper.registProjectInfo(projectDTO);
        return result;
    }

    public int registMakerInfo(MakerDTO makerDTO) {
        int result = userProjectMapper.registMakerInfo(makerDTO);
            if (makerDTO.getMakerName() == null) {
                makerDTO.setMakerName("DefaultName");  // 기본값 설정
            }
        return result;
    }

    
//    여기서 부터 리워드
    public int registRewardInfo(RewardDTO rewardDTO) {//리워드 등록
        int result = userProjectMapper.registRewardInfo(rewardDTO);
        return result;
    }

    //리워드 조회
    public List<RewardDTO> getAllRewards() { //리워드 조회
        return userProjectMapper.getAllRewards();
    }


    //리워드 삭제
   public int deleteReward(int rewardNo) {
       if (!rewardExists(rewardNo)) {
           throw new NoSuchElementException("Reward not found with rewardNo: " + rewardNo);
       }
        return userProjectMapper.deleteReward(rewardNo);
    }


    // rewardNo에 해당하는 데이터가 존재하는지 확인하는 메서드
    private boolean rewardExists(int rewardNo) {
        // SubMapper에서 rewardNo에 해당하는 데이터 조회
        int count = userProjectMapper.countRewardByRewardNo(rewardNo);

        // 조회한 데이터의 개수가 1 이상인 경우 true 반환
        return count > 0;
    }


//    스토리
    public void storyBoard(StoryDTO story){
        userProjectMapper.registStoryInfo(story);


        int storyNo = story.getStoryNo();

        //스토리 이미지 등록
        StoryRepImgDTO storyRepImg = story.getStoryRepImg();
        storyRepImg.setStoryNo(storyNo);
        userProjectMapper.registStoryRepImage(storyRepImg);

    }

}

