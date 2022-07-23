package com.sloopdoge.blog.models;

import com.sloopdoge.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findUserByEmail(email);

        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: "+ email);
        }
        UserDetails user = User.builder()
                .username(myUser.getEmail())
                .password(myUser.getPassword())
                .roles(String.valueOf(myUser.getRole()))
                .build();
        return user;
    }
}
