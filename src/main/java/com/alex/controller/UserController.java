package com.alex.controller;

import com.alex.annotation.History;
import com.alex.model.User;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @History(param = {"id"})
    @GetMapping("/userList")
    public String getUserById(Integer id, Model model) {
        User user = userService.selectUserById(id);
        model.addAttribute("user", user);
        return "userList";
    }

    @History(param = {"userName"})
    @GetMapping("/list")
    public String getUserByName(String userName, Model model) {
        User user = userService.selectUserByName(userName);
        model.addAttribute("user", user);
        return "userList";
    }
}
