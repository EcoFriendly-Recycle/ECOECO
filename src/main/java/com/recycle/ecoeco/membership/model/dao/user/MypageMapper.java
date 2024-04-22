package com.recycle.ecoeco.membership.model.dao.user;

import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    int joinus(UserInfoDTO user);       // 회원가입

    UserInfoDTO selectUserById(String userId);      // 아이디 중복체크

    UserInfoDTO findByUserId(String userId);        // 로그인

    UserInfoDTO findIdByUserNameAndEmail(String userName, String userEmail);        // 아이디 찾기

}
