package com.example.hroauth.services;


import com.example.hroauth.feignclients.UserFeignClients;
import com.example.hroauth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        if(user == null)
            throw new IllegalArgumentException("E-mail not found");

        return user;
    }
}
