package com.recycle.ecoeco.membership.controller.manager;


import com.recycle.ecoeco.membership.model.dto.UserInfoDTO;
import com.recycle.ecoeco.membership.service.manager.AdminCustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/manager/customer")
public class AdminCustomerController {

    private final AdminCustomerService adminCustomerService;

    @Autowired
    public AdminCustomerController(AdminCustomerService adminCustomerService){
        this.adminCustomerService = adminCustomerService;
    }

    @GetMapping("/customer_list")
    public String getCustomers(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(required = false) String searchCondition,
                               @RequestParam(required = false) String searchValue,
                               @RequestParam(required = false) String searchDate1,
                               @RequestParam(required = false) String searchDate2,
                               Model model) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("searchDate1", searchDate1);
        searchMap.put("searchDate2", searchDate2);

        Map<String, Object> boardListAndPaging = adminCustomerService.findCustomerList(searchMap, page);
        model.addAttribute("paging", boardListAndPaging.get("paging"));
        model.addAttribute("customerList", boardListAndPaging.get("boardList"));

        return "/manager/customer/customer_list";
    }

    @GetMapping("/customerInfo")
    public String customer_info(@RequestParam int userNo, Model model) {
        UserInfoDTO customerInfo = adminCustomerService.userListDetail(userNo);
        model.addAttribute("customerInfo", customerInfo);

        return "manager/customer/customer_info";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("userNo") int userNo) {
        System.out.println("======================삭제요청==================================================================");
        System.out.println("userNo: " + userNo); // 받아온 userNo를 출력해서 확인합니다.
        adminCustomerService.deleteCustomer(userNo); // 사용자 삭제 서비스 메서드 호출
        return "redirect:/manager/customer/customer_list"; // 사용자 삭제 후 회원 목록 페이지로 리다이렉트
    }
    // 다음과 같이 업데이트 등급을 처리하는 엔드포인트를 추가합니다.
    @PostMapping("/update-grade")
    public String updateCustomerGrade(@RequestParam("userNo") int userNo, @RequestParam("selectedGrade") int selectedGrade) {
        // 사용자 번호와 선택한 등급을 서비스에 전달하여 등급을 업데이트합니다.
        // 서비스 메서드는 해당 사용자의 등급을 업데이트하고 업데이트 성공 여부를 반환할 것입니다.
        boolean updateSuccess = adminCustomerService.updateCustomerGrade(userNo, selectedGrade);

        if (updateSuccess) {
            return "User grade updated successfully";
        } else {
            return "Failed to update user grade";
        }
    }


}
