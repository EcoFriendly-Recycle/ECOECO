package com.recycle.ecoeco.makerProject.controller.user;

import com.recycle.ecoeco.makerProject.model.dto.*;
import com.recycle.ecoeco.makerProject.service.user.UserProjectService;
import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

//@Slf4j
@Controller
@RequestMapping("/user/project")
public class UserProjectController {
    private final UserProjectService userProjectService;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    private static final Logger log = LoggerFactory.getLogger(UserProjectController.class);

    @Autowired
    public UserProjectController(UserProjectService userProjectService) {
        this.userProjectService = userProjectService;
    }


    @GetMapping("/reward/reward")//리워드 조회
    public String getAllReward(Model model){ //리워드(뷰로 데이터 전송)
        List<RewardDTO> result= userProjectService. getAllRewards();

        if(!result.isEmpty()) {
            model.addAttribute("reward", result);  // 모델에 리워드 리스트 추가
            return "/user/project/reward/reward";
        } else {
            return "/user/project/reward/reward";
        }

    }

    @PostMapping("/rewardInsert")//리워드 등록
    public String registRewardInfo(@ModelAttribute RewardDTO rewardDTO){
        int result= userProjectService.registRewardInfo(rewardDTO);
        if(result > 0) {
            return "/user/project/reward/reward";
        } else {
            return "index";
        }
    }




    @PostMapping("/deleteReward")//리워드 삭제
    public String deleteReward(@RequestParam int rewardNo){
        int result= userProjectService.deleteReward(rewardNo);
        System.out.println("외않덴데1");
        if(result > 0) {
//            System.out.println("외않덴데");
            return "/user/project/reward/reward";
        } else {
            return "/user/project/reward/reward";
        }
    }



    @GetMapping("/maker/maker")
    public void maker(){}
    @PostMapping("/registMaker")
    public String registMakerInfo(@ModelAttribute MakerDTO makerDTO ){
        int result= userProjectService.registMakerInfo(makerDTO);
        if(result > 0) {
            return "/user/project/maker/maker";
        } else {
            return "index";
        }
    }


    @GetMapping("/projectInfo/projectInfo")
    public void projectInfo(){}

    @PostMapping("/registProjectInfo") //프로젝트 등록
    public String registProjectInfo(@ModelAttribute ProjectDTO projectDTO){
       int result= userProjectService.registProjectInfo(projectDTO);
        if(result > 0) {
            System.out.println(result);
            return "/user/project/projectInfo/projectInfo";
        } else {
            return "index";
        }
    }

    @GetMapping("/terms/terms")
    public void terms(){}


    @GetMapping("/story/story")
    public void Story(){}



    @PostMapping("/saveStory") // 스토리 컨트롤러
   public String saveStory(@ModelAttribute StoryDTO storyDTO,
                           @AuthenticationPrincipal UserInfoDTO user,
                           MultipartFile storyImg){
        String storyPath = IMAGE_DIR + "story";
        File dir = new File(storyPath);
        if(!dir.exists()) dir.mkdirs();

        //이미지 정보 확인하고 처리
        StoryRepImgDTO storyRepImg = null;
        try {
            if (storyImg.getSize() > 0) {
                // 이미지 파일이 업로드된 경우
                String StoryOriginFileName = storyImg.getOriginalFilename();
                 log.info("originalFileName : {}", StoryOriginFileName);

                String ext = StoryOriginFileName.substring(StoryOriginFileName.lastIndexOf("."));
                String storySaveName = UUID.randomUUID() + ext;
                log.info("savedFileName : {}", storySaveName);

                /* 서버의 설정 디렉토리에 파일 저장하기 */
                storyImg.transferTo(new File(storyPath + "/" + storySaveName));

                /* DB에 저장할 파일의 정보 설정 */
                storyRepImg = new StoryRepImgDTO();
//                storyRepImg.setStoryRepImgNo(storyRepImgNo);
                storyRepImg.setStoryImageFileName(StoryOriginFileName);
                storyRepImg.setStoryImageSaveName(storySaveName);
                storyRepImg.setStoryImagePath("/uploadFiles/story/");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 게시글 작성 정보 설정
        storyDTO.setUserInfoDTO(user);
        storyDTO.setStoryRepImg(storyRepImg); // 이미지 정보 설정

        // 게시글 서비스를 통해 게시글 작성
        userProjectService.storyBoard(storyDTO); // 이미지 파일도 함께 전달

        // 게시글 리스트로 리다이렉트
        return "redirect:/user/project/story/story";
}


    @GetMapping("/detail/detail")
    public void detail(){}

//    임시 매핑입니다 추후 연결 예정입니다
    @GetMapping("/detail/detail-news")
    public void detailNews(){}

    @GetMapping("/detail/detail-refund")
    public void detailRefund(){}

    @GetMapping("/detail/detail-review")
    public void detailReview(){}

    @GetMapping("/detail/detail-reward")
    public void detailReward(){}
}
