package com.recycle.ecoeco.membership.service.user;

import com.recycle.ecoeco.membership.model.dao.user.MypageMapper;
import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Date;

@Service
public class MyPageService {

    private final MypageMapper mypageMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailService emailService;

   @Autowired
    public MyPageService(MypageMapper mypageMapper, EmailService emailService) {
       this.mypageMapper = mypageMapper;
       this.emailService = emailService;
       this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void joinus(UserInfoDTO user) {
        if(user.getUserPwd() != null) {
            String encodedPassword = passwordEncoder.encode(user.getUserPwd());
            user.setUserPwd(encodedPassword);
        }

        // 회원 가입일 설정
        LocalDate signUpDate = LocalDate.now();

        user.setUserDate(signUpDate);
        System.out.println("User Date Set : " + user.getUserDate());

        // DAO를 통해 회원 정보 DB저장
        mypageMapper.joinus(user);
        System.out.println("User Info Saved to Database");
    }

    public boolean selectUserById(String userId) {
       UserInfoDTO user = mypageMapper.selectUserById(userId);
        return user != null;
    }

    public String findIdByUserNameAndEmail(String userName, String userEmail) {

        UserInfoDTO user = mypageMapper.findIdByUserNameAndEmail(userName, userEmail);

        if (user != null) {
            return user.getUserId();        // 사용자 정보가 있으면 아이디 반환
        } else {
            return null;        // 사용자 정보가 없으면 null 반환
        }
    }

    public String findPwdByUserIdAndUserEmail(String userId, String userEmail) {
        String userPwd = mypageMapper.findPwdByUserIdAndUserEmail(userId, userEmail);

        if(userPwd != null) {
            String temporaryPassword = generateTemporaryPassword();     // 임시 비밀번호 생성
            boolean emailSent = emailService.sendTemporaryPasswordEmail(userEmail, temporaryPassword);

            if(emailSent) {
                mypageMapper.updateUserPassword(passwordEncoder.encode(temporaryPassword), userId);
                return "입력하신 이메일로 임시 비밀번호가 발송되었습니다.";
            } else {
                return "임시 비밀번호 발송에 실패했습니다.";
            }
        } else {
            return "등록된 회원정보가 없습니다.";
        }
    }

    private String generateTemporaryPassword() {
        int length = 10; // 임시 비밀번호의 길이를 결정합니다. 여기서는 10으로 설정합니다.
        StringBuilder sb = new StringBuilder(length);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*"; // 사용할 문자열을 정의합니다.

        // SecureRandom을 사용하여 안전한 랜덤값을 생성합니다.
        SecureRandom random = new SecureRandom();

        // 지정된 길이만큼 반복하여 임시 비밀번호를 생성합니다.
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString(); // 생성된 임시 비밀번호를 반환합니다.
    }
}
