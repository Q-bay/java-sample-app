package com.example.demo.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public String getHome(Model model, @AuthenticationPrincipal User user) {

        log.info("HomeController Start");

        // ログインユーザー情報の表示
        log.info(user.toString());

        log.info("HomeController End");

        return "home";
    }

    // =============================================
    // @AuthenticationPrincipalを使わない場合
    // =============================================
    @GetMapping("/home2")
    public String getHome2(Model model, Principal principal) {

        //ログインユーザー情報の取得(その1)
        Authentication authentication = (Authentication) principal;
        User user1 = (User) authentication.getPrincipal();
        log.info("user1: " + user1.toString());

        //ログインユーザー情報の取得(その2)
        User user2 = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        log.info("user2: " + user2.toString());

        return "home";
    }
}
