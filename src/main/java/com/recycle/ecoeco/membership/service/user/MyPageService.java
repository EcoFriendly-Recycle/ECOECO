package com.recycle.ecoeco.membership.service.user;

import com.recycle.ecoeco.membership.model.dao.user.MypageMapper;
import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MyPageService {

    private final MypageMapper mypageMapper;
    private final BCryptPasswordEncoder passwordEncoder;

   @Autowired
    public MyPageService(MypageMapper mypageMapper) {
        this.mypageMapper = mypageMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void joinus(UserInfoDTO user) {
        if(user.getUserPwd() != null) {
            String encodedPassword = passwordEncoder.encode(user.getUserPwd());
            user.setUserPwd(encodedPassword);
        }

        // 회원 가입일 설정
        Date signUpDate = new Date();

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
}
