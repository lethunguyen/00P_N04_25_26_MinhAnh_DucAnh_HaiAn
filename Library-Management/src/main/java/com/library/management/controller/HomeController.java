package com.library.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller đơn giản cho trang chủ (renders templates/index.html)
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // có thể thêm dữ liệu nếu cần
        return "index";
    }
}
