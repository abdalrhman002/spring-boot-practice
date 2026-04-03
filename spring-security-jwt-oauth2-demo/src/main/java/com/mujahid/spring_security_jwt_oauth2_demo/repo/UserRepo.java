package com.mujahid.spring_security_jwt_oauth2_demo.repo;

import com.mujahid.spring_security_jwt_oauth2_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);


}
