package com.example.demo.security;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

   // private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //logger.debug("Entering in loadUserByUsername Method...");
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            //logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("could not found user..!!");
        }
        //logger.info("User Authenticated Successfully..!!!");
        return new CustomUserDetails(user.orElse(null));
    }
}
