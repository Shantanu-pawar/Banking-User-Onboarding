package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.EntryDTO.UserEntryDto;
import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import com.Banking_User_Onboard.UserOnboarding.ResponseDto.UserCustomNameEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto user){

        // validations check
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

        // Now set the remaining attributes
        User user1 = new User();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setSalary(user.getSalary());
        user1.setExpense(user.getExpense());

        userRepository.save(user1);
        return "user added successfully";
    }


    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public UserCustomNameEmail getCustomUser(int id) throws Exception {

        Optional<User> user = userRepository.findById(id);
        // validating user using optional
        if (!user.isPresent()) {
            throw new Exception("User not able to find");
        }

        // Creating objects setting attr -> then return the obj.
        UserCustomNameEmail userCustomNameEmail = new UserCustomNameEmail();
        User user1 = user.get();

        userCustomNameEmail.setEmail(user1.getEmail());
        userCustomNameEmail.setName(user1.getName());

        return userCustomNameEmail;
    }


    public String updateUser(UserEntryDto userEntryDto, int id){

        Optional<User> userOptional = userRepository.findById(id);

        User user = userOptional.get();
        user.setName(userEntryDto.getName());
        user.setEmail(userEntryDto.getEmail());

        // NOTE : here what we're setting the params only those get updated other are remains same
        // so if we set all the params then whole user obj get updated.

        userRepository.save(user);
        return "User updated Successfully";
    }


    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}
