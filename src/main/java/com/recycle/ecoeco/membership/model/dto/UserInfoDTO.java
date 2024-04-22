package com.recycle.ecoeco.membership.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;


@ToString @Setter @Getter
public class UserInfoDTO implements UserDetails {
    private int userNo;             // 회원번호
    private String userId;
    private String userPwd;
    private String userName;
    private String userPnum;
    private String userEmail;
    private String userBirth;
    private char userGender;
    private int userGrade;
    private int userPoint;
    private Date userDate;
    private int userAccount;
    private String userAddress;
    private UserRole userRole;

    private boolean passResult;

//    private Bank_accountDTO Bank_account;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        String roleName = "";
        if(userRole != null) roleName = userRole.name();

        System.out.println(roleName);

        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
