package com.ttrpg.helper.services.auth;

import com.ttrpg.helper.services.auth.dto.UserDetailsDTO;
import com.ttrpg.helper.services.auth.dto.UsersListDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static com.ttrpg.helper.services.auth.AuthConstants.AUTHORIZATION_SERVICE;

public class AuthClient {
    public static UserDetails loadUserByUsername(String username, RestTemplate restTemplate) throws UsernameNotFoundException {
        UserDetailsDTO res = restTemplate.getForObject(AUTHORIZATION_SERVICE + "authorization?u=" + username, UserDetailsDTO.class);

        if (res == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Unauthorized: User data not found: " + username);
        }

        return org.springframework.security.core.userdetails.User.withUsername(res.getUsername())
                .password(res.getPassword())
                .roles(res.getRoles().get(0))
                .build();
    }

    public static UsersListDTO loadAllUsers(RestTemplate restTemplate) throws UsernameNotFoundException {
        return restTemplate.getForObject(AUTHORIZATION_SERVICE + "authorization/all", UsersListDTO.class);
    }
}