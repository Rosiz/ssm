package com.gdpi.ssm.controller;

import com.gdpi.ssm.domain.UserInfo;
import com.gdpi.ssm.service.IGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GlobalController {
    @Autowired
    private IGlobalService iGlobalService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) throws Exception {
        System.out.println("此方法执行了");
        UserInfo user = iGlobalService.login(username,password);
        if(user==null){
            return "redirect:/to_login";
        }
        session.setAttribute("user",user);
        System.out.println("执行成功");
        
        return "main";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        return "redirect:to_login";
    }
}
