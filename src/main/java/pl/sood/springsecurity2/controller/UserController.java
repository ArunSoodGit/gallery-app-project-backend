package pl.sood.springsecurity2.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sood.springsecurity2.model.AppUser;
import pl.sood.springsecurity2.repository.AppUserRepo;
import pl.sood.springsecurity2.service.UserService;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private UserService userService;
    private AppUserRepo appUserRepo;


    public UserController(UserService userService, AppUserRepo appUserRepo) {
        this.userService = userService;
        this.appUserRepo = appUserRepo;

    }



    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new AppUser());
     return "zalogowano";
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {

        return "sing-up";
    }

    @GetMapping("/register")
    public String register(AppUser appUser) {
       userService.addUser(appUser);
        return "sing-up";
    }


}
