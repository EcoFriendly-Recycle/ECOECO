package com.recycle.ecoeco.common.main.controller;

import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import com.recycle.ecoeco.membership.service.user.MyPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final MyPageService myPageService;

    public MainController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }

    @GetMapping("/adminMain")
    public void managerMainPage() {}

    /* 메인페이지에서 로그인페이지 이동 */
    @GetMapping("/login")
    public void headerLoginPage() {}

    /* 메인페이지 에서 회원가입 페이지 이동 */
    @GetMapping("/joinus")
    public void headerJoinUsPage() {}

    /* 회원가입 처리 */
    @PostMapping("/joinus")
    public String joinus(UserInfoDTO user) {

        myPageService.joinus(user);

        return "redirect:/templates/login";
    }

}