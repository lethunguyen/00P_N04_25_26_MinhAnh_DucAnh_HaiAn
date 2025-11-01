package com.library.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Xử lý trang chủ và login.
 * HTML chính đã được chuyển vào templates/index.html.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        // hiển thị form đăng nhập ở templates/auth/login.html
        return "auth/login";
    }

    @GetMapping("/")
    public String home() {
        // trả về giao diện chính index.html
        return "index";
    }
}
