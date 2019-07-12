package com.lx.controller;

import com.lx.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminServiceImp adminImp;

    @RequestMapping("/show")
    public String show() {

        return "login";
    }
   /* @RequestMapping("/showIndex")
    public String showIndex() {

        return "index.jsp";
    }*/
    @RequestMapping("/loginUser")
    @ResponseBody
    public String validte(User user, HttpSession session) {
        boolean login = adminImp.isLogin(user);
        System.out.println(login);
        if (login){

            session.setAttribute("userAccount",user.getEmail());
            return "success";
        } else{
            return "fail";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin) {
        boolean result = adminImp.isSus(admin);
        System.out.println(result);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String save(User user) {
        boolean b = adminImp.userMess(user);
        if (b) {
            return "success";
        } else {
            return "fail";
        }
    }


}
