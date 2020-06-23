package pl.sood.springsecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sood.springsecurity2.model.AppUser;
import pl.sood.springsecurity2.repository.AppUserRepo;
import pl.sood.springsecurity2.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    private UserService userService;
    private AppUserRepo appUserRepo;


    public UserController(UserService userService, AppUserRepo appUserRepo) {
        this.userService = userService;
        this.appUserRepo = appUserRepo;

    }



    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
    //    Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
      //  Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
       // model.addAttribute("authorities", authorities);
      //  model.addAttribute("details", details);
        return "hello";
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {
        model.addAttribute("user", new AppUser());
        return "sing-up";
    }

    @PostMapping("/register")
    public String register(AppUser appUser) {
       userService.addUser(appUser);
        return "sing-up";
    }


}
