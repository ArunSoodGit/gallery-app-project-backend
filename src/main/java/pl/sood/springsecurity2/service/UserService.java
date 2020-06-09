package pl.sood.springsecurity2.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sood.springsecurity2.model.AppUser;
import pl.sood.springsecurity2.repository.AppUserRepo;

@Service
public class UserService {



    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;


    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;

    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setUsername(appUser.getUsername());
        appUser.setId(appUser.getId());
        appUser.setRole("ROLE_USER");
        appUserRepo.save(appUser);

    }


}
