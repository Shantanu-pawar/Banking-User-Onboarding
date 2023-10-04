package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        int salary = user.getSalary();
        int expense = user.getExpense();
        int balance = salary - expense;

        if(salary - expense <= 1000) {
            return "not able to create Account : " + balance + " is less than 1000";
        }

        userRepository.save(user);
        return "user added successfully";
    }


    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User updatedUser) {

//        apply try catch block here or optional is also fine!!
    try {
        User existingUser = userRepository.findById(id).orElse(null);
            if (existingUser != null) {
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setName(updatedUser.getName());
                existingUser.setSalary(updatedUser.getSalary());
                existingUser.setExpense(updatedUser.getExpense());
                return userRepository.save(existingUser);
            }
            else return null;
        }

        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}
