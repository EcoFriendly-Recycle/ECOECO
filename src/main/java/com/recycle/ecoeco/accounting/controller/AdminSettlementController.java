package com.recycle.ecoeco.accounting.controller;

import com.recycle.ecoeco.accounting.model.dto.SettlementDTO;
import com.recycle.ecoeco.accounting.service.AdminSettlementService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/manager/ordertab/settlement")
public class AdminSettlementController {

    private final AdminSettlementService settlementService;

    @Autowired
    public AdminSettlementController(AdminSettlementService settlementService){
        this.settlementService = settlementService;
    }

    @GetMapping("/settlement_list")
    public String getCalculateList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(required = false) String searchCondition,
                                 @RequestParam(required = false) String searchValue,
                                 @RequestParam(required = false) String searchDate1,
                                 @RequestParam(required = false) String searchDate2,
                                 Model model){
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("searchDate1", searchDate1);
        searchMap.put("searchDate2", searchDate2);

        Map<String, Object> boardListAndPaging = settlementService.findSettlementList(searchMap, page);
        model.addAttribute("paging", boardListAndPaging.get("paging"));
//        model.addAttribute("boardList", boardListAndPaging.get("boardList"));
        model.addAttribute("settlementList", boardListAndPaging.get("boardList"));

        System.out.println("boardListAndPaging : " + boardListAndPaging);

        return "/manager/ordertab/settlement/settlement_list";
//        List<SettlementDTO> settlementList = settlementService.findSettlementList();
//        model.addAttribute("settlementList", settlementList);
    }

    @GetMapping("/settlement_info")
    public String calculateInfo(@RequestParam int settlementNo, Model model) {
        SettlementDTO settlementInfo = settlementService.settlementListDetail(settlementNo);

        // 달성률 계산하여 DTO에 추가
        double achievementRate =
                //projectDTO에 getAchievedAmount()없음
                ((double) settlementInfo.getProject().getAchievedAmount() /
                        (double) settlementInfo.getProject().getTargetAmount()) * 100;

        // 소수점 두 자리까지 형식화
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedAchievementRate = df.format(achievementRate);

        // 형식화된 달성률을 DTO에 추가
        settlementInfo.setAchievementRate(Double.parseDouble(formattedAchievementRate));

        log.info("settlementInfo : {}", settlementInfo);
        model.addAttribute("settlementInfo", settlementInfo);

        return "manager/ordertab/settlement/settlement_info";
    }
//@GetMapping("/settlement_info")
//public String calculateInfo(@RequestParam int settlementNo, Model model) {
//    SettlementDTO settlementInfo = settlementService.settlementListDetail(settlementNo);
//    System.out.println("settlementInfo : " + settlementInfo);
//    if (settlementInfo != null) {
//        // 달성률 계산
//        double achievementRate =
//                ((double) settlementInfo.getProject().getAchievedAmount() /
//                        (double) settlementInfo.getProject().getTargetAmount()) * 100;
//
//        // 소수점 두 자리까지 형식화
//        DecimalFormat df = new DecimalFormat("#.##");
//        String formattedAchievementRate = df.format(achievementRate);
//
//        // 형식화된 달성률을 DTO에 추가
//        settlementInfo.setAchievementRate(Double.parseDouble(formattedAchievementRate));
//
//        log.info("settlementInfo : {}", settlementInfo);
//        model.addAttribute("settlementInfo", settlementInfo);
//    } else {
//        // settlementInfo가 null일 때의 처리
//        // 예를 들어, 에러 메시지를 모델에 추가하거나 다른 처리를 수행할 수 있습니다.
//    }
//
//    return "manager/ordertab/settlement/settlement_info";
//}


}
