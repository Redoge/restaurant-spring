package app.redoge.restaurant.controllers;


import app.redoge.restaurant.entity.User;
import app.redoge.restaurant.repository.UserRepository;
import app.redoge.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    final String preffixPath= "/templates/";
    @GetMapping("/")
    public String showMain(Model model) {

        String role =userService.getAuthorizedUserRoles().toArray()[0].toString();
        if(role.equals("client"))return "client/main_client";
        if(role.equals("manager"))return "manager/main_manager";
        if(role.equals("admin"))return "admin/main_admin";
        return "main";
    }

    @GetMapping("/register")
    public String showRegisterPage(@ModelAttribute("user") User user){
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@ModelAttribute("user")  @Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/static/style")
    public String getStyles(){
        return "css/style.css";
    }

}
