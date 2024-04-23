package com.recycle.ecoeco.board.notice.service.manager;


import com.recycle.ecoeco.board.notice.model.dao.manager.AdminNoticeMapper;
import com.recycle.ecoeco.board.notice.model.dto.NoticeDTO;
import com.recycle.ecoeco.common.paging.Pagenation;
import com.recycle.ecoeco.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
@Transactional
public class AdminNoticeService {

    private final AdminNoticeMapper adminNoticeMapper;

    public AdminNoticeService(AdminNoticeMapper adminNoticeMapper) {
        this.adminNoticeMapper = adminNoticeMapper;
    }

    /* 공지사항 리스트 조회 */
//    public List<NoticeDTO> selectNoticeList() {
//        return noticeMapper.selectNoticeList();
//    }
    public Map<String, Object> selectNoticeList(Map<String, String> searchMap, int page) {
        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = adminNoticeMapper.selectTotalCount(searchMap);
        log.info("noticeList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("noticeList selectCriteria : {}", selectCriteria);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
        List<NoticeDTO> noticeList = adminNoticeMapper.selectNoticeList(selectCriteria);
        log.info("noticeList : {}", noticeList);

        Map<String, Object> noticeListAndPaging = new HashMap<>();
        noticeListAndPaging.put("paging", selectCriteria);
        noticeListAndPaging.put("noticeList", noticeList);

        return noticeListAndPaging;
    }

    // 공지 상세보기
    public NoticeDTO selectNoticeDetail(int noticeNo) {

        return adminNoticeMapper.selectNoticeDetail(noticeNo);
    }

    // 공지사항 작성
    public void writeBoard(NoticeDTO notice) {

        notice.setNoticeCategory(notice.getNoticeCategory());
        adminNoticeMapper.insertNotice(notice);
    }

    // 공지사항 삭제
    public void deleteNotice(NoticeDTO deleteNotice) {

        adminNoticeMapper.deleteNotice(deleteNotice);
    }

    // 공지사항 작성 정보 불러오기 (수정페이지)
    public NoticeDTO noticeModify(int noticeNo) {
        return adminNoticeMapper.noticeModify(noticeNo);
    }

    // 공지사항 수정 등록
    public void updateNotice(NoticeDTO notice) {
        // 공지사항 번호로 기존 엔티티를 조회
        NoticeDTO existingNotice = adminNoticeMapper.noticeModify(notice.getNoticeNo());

        // 조회된 엔티티가 존재할 경우에만 업데이트 수행
        if (existingNotice != null) {
            // 기존 엔티티의 필드를 새로운 값으로 업데이트
            existingNotice.setNoticeCategory(notice.getNoticeCategory());
            existingNotice.setNoticeSubCategory(notice.getNoticeSubCategory());
            existingNotice.setNoticeTitle(notice.getNoticeTitle());
            existingNotice.setNoticeDetail(notice.getNoticeDetail());
            existingNotice.setNoticeDate(LocalDate.now());

            // 엔티티 저장
            adminNoticeMapper.updateNotice(existingNotice);
        } else {
            // 엔티티가 존재하지 않을 경우 예외 처리 또는 로그 등 수행
            log.info("됐나유?");
        }
    }
}
