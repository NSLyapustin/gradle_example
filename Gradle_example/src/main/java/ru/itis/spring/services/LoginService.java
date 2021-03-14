package ru.itis.spring.services;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.spring.auth.ApplicationUserDetails;
import ru.itis.spring.model.ApplicationUser;
import ru.itis.spring.repository.ApplicationUserRepository;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = userRepository.getByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("err");
        }

        return new ApplicationUserDetails(user);
    }


    public ApplicationUser save(ApplicationUser user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        return userRepository.save(user);
    }
}
