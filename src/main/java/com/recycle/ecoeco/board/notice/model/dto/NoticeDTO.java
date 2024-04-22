package com.recycle.ecoeco.board.notice.model.dto;


import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
public class NoticeDTO {

    private int noticeNo;                   // 공지사항 번호

    private String noticeCategory;          // 공지사항 분류

    private String noticeSubCategory;       // 공지사항 소분류 : FAQ만 해당(메이커/서포터)

    private String noticeTitle;             // 공지사항 제목

    private String noticeDetail;            // 공지사항 상세 내용

    private LocalDate noticeDate;           // 공지사항 작성날짜

    private char noticeStatus;              // 공지사항 삭제여부

    private int userNo;

    private UserInfoDTO writer;             // 회원DTO에 이름 == 공지사항DTO 작성자 (관리자만 해당)

    private NoticeImageDTO image;

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeCategory, String noticeSubCategory, String noticeTitle, String noticeDetail, LocalDate noticeDate, char noticeStatus, int userNo, UserInfoDTO writer, NoticeImageDTO image) {
        this.noticeNo = noticeNo;
        this.noticeCategory = noticeCategory;
        this.noticeSubCategory = noticeSubCategory;
        this.noticeTitle = noticeTitle;
        this.noticeDetail = noticeDetail;
        this.noticeDate = noticeDate;
        this.noticeStatus = noticeStatus;
        this.userNo = userNo;
        this.writer = writer;
        this.image = image;
    }
}
