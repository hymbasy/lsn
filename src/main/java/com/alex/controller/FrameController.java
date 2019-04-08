package com.alex.controller;

import com.alex.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frame")
public class FrameController {

    @RequestMapping(value="/top")
    public String top(Model model, HttpServletRequest request){
        HttpSession session =request.getSession();
        User user=(User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/frame/top";
    }
}
