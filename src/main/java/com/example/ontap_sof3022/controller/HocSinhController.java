package com.example.ontap_sof3022.controller;

import com.example.ontap_sof3022.model.HocSinh;
import com.example.ontap_sof3022.repo.HocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hoc-sinh")
public class HocSinhController {
    @Autowired
    HocSinhRepo hocSinhRepo;
    @GetMapping("/hien-thi")
public String hienThi(Model model){
List<HocSinh> listHocSinh = hocSinhRepo.findAll();
model.addAttribute("listHocSinh",listHocSinh);
    return "hien-thi.html";
}
}
