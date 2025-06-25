package com.ttrpg.auth.repositories;


import com.ttrpg.helper.services.auth.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndEmail(String username, String email);
}
