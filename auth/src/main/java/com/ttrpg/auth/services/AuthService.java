package com.ttrpg.auth.services;

import com.ttrpg.auth.repositories.UsersRepository;
import com.ttrpg.helper.services.auth.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(String.valueOf(user.getRoles()))
                        .build();
            }
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User n) {
        userRepository.save(n);
    }

    public boolean existsByUsername(String u) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(u)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email) != null;
    }
}