package com.example.hroauth.services;


import com.example.hroauth.feignclients.UserFeignClients;
import com.example.hroauth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        if(user == null)
            throw new IllegalArgumentException("E-mail not found");

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeignClients.findByEmail(s).getBody();
        if(user == null)
            throw new UsernameNotFoundException("E-mail not found");

        return user;
    }
}
