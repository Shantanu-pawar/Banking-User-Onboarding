package com.Banking_User_Onboard.UserOnboarding.Repository;

import com.Banking_User_Onboard.UserOnboarding.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

}
