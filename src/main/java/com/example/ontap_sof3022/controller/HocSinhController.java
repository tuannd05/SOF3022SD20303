package com.example.ontap_sof3022.controller;

import com.example.ontap_sof3022.model.HocSinh;
import com.example.ontap_sof3022.repo.HocSinhRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hoc-sinh")
public class HocSinhController {
    @Autowired
    private HocSinhRepo hocSinhRepo;

//hienThi
    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("hocSinh", new HocSinh());
        model.addAttribute("listHocSinh", hocSinhRepo.findAll());
        return "hien-thi.html";
    }

// search
    @GetMapping("/tim-kiem")
    public String timKiem(@RequestParam(required = false) String key, Model model) {

        model.addAttribute("hocSinh", new HocSinh());

        if (key == null || key.trim().isEmpty()) {
            model.addAttribute("message", "Khong co tu khoa tim kiem");
            model.addAttribute("listHocSinh", hocSinhRepo.findAll());
        } else {
            model.addAttribute("key", key);
            model.addAttribute("listHocSinh", hocSinhRepo.searchAll(key));
        }

        return "hien-thi.html";
    }

    //xu ly form them moi
    @PostMapping("/them")
//    @ModelAttribute("hocSinh") HocSinh hocSinh:
//    Spring MVC tự map các input name trong form
//    vào thuộc tính tương ứng của entity HocSinh.
    // Note: Errors errors đứng ngay sau @Valid
    public String themMoi(
            Model model,
            @Valid @ModelAttribute("hocSinh") HocSinh hocSinh,
            Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("listHocSinh", hocSinhRepo.findAll());
            return "hien-thi.html";
        }
        hocSinhRepo.save(hocSinh);
        return "redirect:/hoc-sinh/hien-thi";
    }

    //    return "redirect:/hoc-sinh/hien-thi": Redirect về trang
//    danh sách sau khi lưu thành công (tránh submit lại khi refresh).

    //delete
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        hocSinhRepo.deleteById(id);
        return "redirect:/hoc-sinh/hien-thi";
    }

    //view-update
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("hocSinh", hocSinhRepo.findById(id).orElse(null));
        return "chi-tiet.html";
    }

    //update
    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute("hocSinh") HocSinh hocSinh,
            Errors errors) {

        if (errors.hasErrors()) {
            return "chi-tiet.html";
        }
        hocSinh.setId(id);
        hocSinhRepo.save(hocSinh);
        return "redirect:/hoc-sinh/hien-thi";
    }
}
