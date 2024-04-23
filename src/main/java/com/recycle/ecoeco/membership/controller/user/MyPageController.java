package com.recycle.ecoeco.membership.controller.user;

import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import com.recycle.ecoeco.membership.service.user.AuthService;
import com.recycle.ecoeco.membership.service.user.EmailService;
import com.recycle.ecoeco.membership.service.user.MyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Optional;

import static com.recycle.ecoeco.membership.service.user.PasswordGenerator.generateTemporaryPassword;


@Slf4j
@Controller
@RequestMapping("/user/mypage")
public class MyPageController {

    private final MyPageService myPageService;
    private AuthService authenticationService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public MyPageController(MyPageService myPageService, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.myPageService = myPageService;
        this.emailService = emailService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    /* 로그인 실패 시 */
    @PostMapping("/loginfail")
    public String loginFailed(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.");
        System.out.println("로그인 실패");
        return "redirect:/login";
    }

    /* 아이디 중복 검사 */
    @ResponseBody
    @GetMapping("/selectUserById")
    public ResponseEntity<String> selectUserById(@RequestParam String userId) {
        boolean isDuplicate = myPageService.selectUserById(userId);
        if(isDuplicate) {
            return ResponseEntity.status(HttpStatus.OK).body("true");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("false");
        }
    }

    /* 아이디 비밀번호 찾기 선택 페이지 이동 */
    @GetMapping("/findSearchInfo")
    public void findSearchInfoPage() {}

    /* 아이디 찾기 페이지 이동 */
    @GetMapping("/findId")
    public void findIdPage() {}

    /* 아이디 찾기 */
    @PostMapping("/findId")
    public ResponseEntity<String> findId(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {

        // 서비스로부터 아이디를 찾는 로직을 호출하고 결과를 반환합니다.
        String foundUserId = myPageService.findIdByUserNameAndEmail(userName, userEmail);

        if (foundUserId != null) {
            // 아이디를 찾았을 경우
            return ResponseEntity.ok("회원님의 아이디는 " + foundUserId + " 입니다.");
        } else {
            // 아이디를 찾지 못했을 경우
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("등록된 회원이 아닙니다.");
        }
    }

    /* 비밀번호 찾기 페이지 이동 */
    @GetMapping("/findPwd")
    public void findPwdPage() {}

    /* 비밀번호 찾기 구현 메소드 */
    @PostMapping("/findPwd")
    public ResponseEntity<String> findPwd(@RequestParam("searchPwdId") String userId, @RequestParam("searchPwdEmail") String userEmail) {
        String foundPwd = myPageService.findPwdByUserIdAndUserEmail(userId, userEmail);

        if(foundPwd != null) {
            String temporaryPassword = generateTemporaryPassword();     // 임시비밀번호 생성
            boolean emailSent = emailService.sendTemporaryPasswordEmail(userEmail, temporaryPassword);

            System.out.println("userEmail : " + userEmail);
            System.out.println("temporaryPassword : " + temporaryPassword);
            System.out.println("emailSent : " + emailSent);

            if(emailSent) {
                // 임시 비밀번호 전송 성공 시 db에 임시 비밀번호 저장

                // 이메일 전송 성공 메시지
                return ResponseEntity.ok("입력하신 이메일로 임시 비밀번호가 발송되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("임시 비밀번호 발송에 실패하였습니다.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("등록된 회원정보가 없습니다.");
        }
    }
    
    /* 마이페이지 이동 메일화면 이동 */
    @GetMapping("/mypageMain")
    public void mypageMainPage() {}

    /* 서포터 나의 프로젝트 이동 */
    @GetMapping("/mypage_MyProject")
    public void mypage_MyProjectPage() {}

    /* 후원한 프로젝트 이동 */
    @GetMapping("/mypage_SupportProject")
    public void mypage_SupportProjectPage() {}

    /* 후원한 프로젝트 상세보기 이동 */
    @GetMapping("/mypage_SupportProject_Detail")
    public void mypage_SupportProject_DetailPage() {}

    /* 내정보 이동 */
    @GetMapping("/mypage_CheckMyInfo")
    public void mypage_CheckMyInfoPage() {}

    /* 메이커 페이지 이동 */
    @GetMapping("/mypageMain_Maker")
    public void mypageMain_MakerPage() {}

    /* 메이커 나의 프로젝트 이동 */
    @GetMapping("/mypage_MyprojectList")
    public void mypage_MyprojectListPage() {}

    /* 메이커 나의 프로젝트 상세화면 이동 */
    @GetMapping("/mypage_MyprojectList_Detail")
    public void mypage_MyprojectList_DetailPage() {}

    /* 메이커 나의 프로젝트 상세페이지 결제현황 이동 */
    @GetMapping("/payment_Status")
    public void payment_StatusPage() {}

    /* 메이커 나의 프로젝트 상세페이지 정산정보 이동 */
    @GetMapping("/settlement_Info")
    public void settlement_InfoPage() {}

    /* 메이커 나의 프로젝트 상세페이지 정산정보 -> 정산내역 이동 */
    @GetMapping("/settlement_Info_Details")
    public void settlement_Info_DetailsPage() {}

    /* 메이커 나의 프로젝트 상세페이지 새소식 이동 */
    @GetMapping("/news")
    public void newsPage() {}

    /* 새소식 등록 페이지 이동 */
    @GetMapping("/registNews")
    public void registNewsPage() {}

    /* 새소식 조회 페이지 이동 */
    @GetMapping("/registNewsDetail")
    public void registNewsDetailPage() {}
}
