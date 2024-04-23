package com.recycle.ecoeco.makerProject.model.dto;

import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;

import java.time.LocalDate;

public class NewsDTO {

    private int newsNo;
    private String newsCategory;
    private String newsTitle;
    private String newsContent;
    private LocalDate newsDate;
    private String newsImage;
    private int projectNo;
    private ProjectDTO project;
    private int userNo;
    private UserInfoDTO userInfo;

    public NewsDTO() {
    }

    public NewsDTO(int newsNo, String newsCategory, String newsTitle, String newsContent, LocalDate newsDate, String newsImage, int projectNo, int userNo) {
        this.newsNo = newsNo;
        this.newsCategory = newsCategory;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.newsImage = newsImage;
        this.projectNo = projectNo;
        this.userNo = userNo;
    }

    public NewsDTO(int newsNo, String newsCategory, String newsTitle, String newsContent, LocalDate newsDate, String newsImage, int projectNo, ProjectDTO project, int userNo, UserInfoDTO userInfo) {
        this.newsNo = newsNo;
        this.newsCategory = newsCategory;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.newsImage = newsImage;
        this.projectNo = projectNo;
        this.project = project;
        this.userNo = userNo;
        this.userInfo = userInfo;
    }

    public int getNewsNo() {
        return newsNo;
    }

    public void setNewsNo(int newsNo) {
        this.newsNo = newsNo;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "newsNo=" + newsNo +
                ", newsCategory=" + newsCategory +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsDate=" + newsDate +
                ", newsImage='" + newsImage + '\'' +
                ", projectNo=" + projectNo +
                ", project=" + project +
                ", userNo=" + userNo +
                ", userInfo=" + userInfo +
                '}';
    }
}