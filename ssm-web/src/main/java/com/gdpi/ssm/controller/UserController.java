package com.gdpi.ssm.controller;

import com.gdpi.ssm.domain.UserInfo;
import com.gdpi.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> map){
        map.put("userList",iUserService.findAll());
        return "user-list";
    }

    @RequestMapping("/toSave")
    public String toSave(Map<String,Object> map){
        map.put("userAdd",new UserInfo());
        return "user-add";
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        iUserService.save(userInfo);
        return "redirect:/user/findAll";
    }
}
