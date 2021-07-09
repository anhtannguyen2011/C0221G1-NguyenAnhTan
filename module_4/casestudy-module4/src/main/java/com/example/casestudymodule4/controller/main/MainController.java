package com.example.casestudymodule4.controller.main;

import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Employee;
import com.example.casestudymodule4.model.service.employee.IAppUserService;
import com.example.casestudymodule4.model.service.employee.IEmployeeService;
import com.example.casestudymodule4.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@SessionAttributes("employeeSession")
public class MainController {

    @Autowired
    private IAppUserService userService;
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("employeeSession")
    public Employee getEmployee(@CookieValue(name = "username", defaultValue = "") String username) {
        if (username.equals("")) {
            return new Employee();
        }
        return this.employeeService.findByUser(this.userService.findByUserName(username));
    }
    @GetMapping("/")
    public String redirectToLoginFirst() {
//        String userDetails = principal.getName();
//        System.err.println(userDetails);

        return "homePage";
    }

    @GetMapping("/home")
    public String getHome(@CookieValue(name = "username", defaultValue = "") String username, Principal principal,
                          Model model, HttpServletResponse response) {
        String uName;
        if (principal == null) {
            uName = username;
        } else {
            uName = principal.getName();
        }
        System.out.println(uName);
        AppUser user = this.userService.findByUserName(uName);
        Cookie cookie = new Cookie("username", uName);
        cookie.setMaxAge(3 * 60 * 60);
        response.addCookie(cookie);
        model.addAttribute("employeeSession", this.employeeService.findByUser(user));
        return "homePage";
    }
    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logout(){
        return "/homePage";

    }

    @GetMapping("/403")
    public String error403(){
        return "/403Page";
    }
}
