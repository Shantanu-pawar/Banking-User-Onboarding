package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        int salary = user.getSalary();
        int expense = user.getExpense();
        int balance = salary - expense;

        if(salary - expense <= 1000) {
            return "not able to create User's Account \n" +
                    " cause the balance :  " + balance + " is less than 1000";
        }

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            return "This Email is already in use. Please enter new one : ";
        }
        userRepository.save(user);
        return "user added successfully";
    }


    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User user) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User existingUser = optionalUser.get();

                existingUser.setEmail(user.getEmail());
                existingUser.setName(user.getName());
                existingUser.setExpense(user.getExpense());
                existingUser.setSalary(user.getSalary());
                return userRepository.save(existingUser);
            }
            else return null;
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}
