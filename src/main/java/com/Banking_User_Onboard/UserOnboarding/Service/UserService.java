package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public String addUser(User user){
        userRepository.save(user);
        return "user added";
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User updatedUser){

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setName(updatedUser.getName());
            existingUser.setSalary(updatedUser.getSalary());
            existingUser.setExpense(updatedUser.getExpense());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}