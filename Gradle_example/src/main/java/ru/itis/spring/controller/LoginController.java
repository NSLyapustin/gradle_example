package ru.itis.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring.auth.ApplicationUserDetails;
import ru.itis.spring.model.ApplicationUser;
import ru.itis.spring.repository.ApplicationUserRepository;
import ru.itis.spring.services.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/registration")
    public ApplicationUser register(@RequestBody ApplicationUser user) {
        return loginService.save(user);
    }
}
