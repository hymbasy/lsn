package com.alex.controller;

import com.alex.model.User;
import com.alex.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord) {
        HttpSession session = request.getSession();
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(passWord)) {
            return new ModelAndView("index", "error", "请输入用户名或密码");
        } else {
            User user = userService.selectUserByNameAndPassword(userName, passWord);
            if (user == null) {
                return new ModelAndView("index", "error", "用户名或密码错误");
            } else {
                session.setAttribute("user", user);
                return new ModelAndView("/success");
            }
        }
    }

    @RequestMapping(value="/frame")
    public String frame(Model model, HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "/userList";
    }


}
