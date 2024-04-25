package com.recycle.ecoeco.membership.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recycle.ecoeco.accounting.model.dto.BankAccountDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
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
    private LocalDate userDate;
    private int userAccount;
    private String userAddress;
    private UserRole userRole;

    private boolean passResult;

    private BankAccountDTO Bank_account;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        String roleName = "";
        if(userRole != null) roleName = userRole.name();

        System.out.println(roleName);

        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPnum() {
        return userPnum;
    }

    public void setUserPnum(String userPnum) {
        this.userPnum = userPnum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public char getUserGender() {
        return userGender;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public LocalDate getUserDate() {
        return userDate;
    }

    public void setUserDate(LocalDate userDate) {
        this.userDate = userDate;
    }

    public int getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(int userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isPassResult() {
        return passResult;
    }

    public void setPassResult(boolean passResult) {
        this.passResult = passResult;
    }

    public BankAccountDTO getBank_account() {
        return Bank_account;
    }

    public void setBank_account(BankAccountDTO bank_account) {
        Bank_account = bank_account;
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
