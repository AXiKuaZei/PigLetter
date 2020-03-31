package cn.pigletter.controller;

import cn.pigletter.model.User;
import cn.pigletter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginG(){
        return "/login";
    }

    @PostMapping("/login")
    public ModelAndView loginP(String username, String password, HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUserByName(username);
        if(user!=null && user.getUser_password().equals(password) ){
            mv.addObject("msg", "welcome!"+username);
            req.getSession().setAttribute("user", user);
            mv.setViewName("personalCenter");
        }else{
            mv.addObject("msg", "用户名或密码错误,请重试");
            mv.setViewName("login");
        }
        return mv;
    }


    @GetMapping("/register")
    public String registerG(){
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerP(String username, String password, String password2, String email){
        ModelAndView mv = new ModelAndView();
        if(password.equals(password2)){
            if(!userService.containsUser(username)){
                User user = new User(username,password,email);
                userService.insertNewUser(user);
                mv.addObject("msg","恭喜您，"+ username +"，注册成功！已自动为您跳转到登录界面");
                mv.setViewName("login");
            }else{
                mv.addObject("msg","注册失败，用户名已存在");
                mv.setViewName("register");
            }
        }else{
            mv.addObject("msg","两次密码输入不一致");
            mv.setViewName("register");
        }
        return mv;
    }
}
