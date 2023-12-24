package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.EntryDTO.UserEntryDto;
import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import com.Banking_User_Onboard.UserOnboarding.ResponseDto.GetOnlyNameEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto user){

        // validations for account balance is >= 1000
        int salary = user.getSalary(); int expense = user.getExpense();
        int balance = salary - expense;
        if(salary - expense <= 1000) {
            return "not able to create User's Account cause the balance : " + balance +
                    " is less than 1000";
        }

        // if email is already present validation
        Optional<User> emailCheck = userRepository.findByEmail(user.getEmail());
        if(emailCheck.isPresent()) return "This Email is already in use. Please enter new one : ";

        // Now set the remaining attributes
        User user1 = new User(user.getExpense(), user.getEmail(),
                user.getName(), user.getSalary(), user.getExpense());

        userRepository.save(user1);
        return "user added successfully";
    }

    public List<GetOnlyNameEmailResponse> getAllUsersAsCustom() throws Exception {
        List<User> userList = userRepository.findAll();

        // 1st method
        List<GetOnlyNameEmailResponse> dtoList = new ArrayList<>();
        for(User user: userList){
            GetOnlyNameEmailResponse response = new GetOnlyNameEmailResponse(user.getEmail(), user.getName());
            dtoList.add(response);
        }

//        // 2nd method
//        List<GetOnlyNameEmailResponse> dtoList = userList.stream()
//                .map(user -> new GetOnlyNameEmailResponse(user.getEmail(), user.getName()))
//                .collect(Collectors.toList());

        return dtoList;
    }

    public String updateUser(UserEntryDto userEntryDto) throws Exception{

        Optional<User> userOptional = userRepository.findById(userEntryDto.getId());
        if(!userOptional.isPresent()){
            throw new Exception("User is not present so can't update");
        }

        User user = userOptional.get();
        user.setName(userEntryDto.getName());
        user.setEmail(userEntryDto.getEmail());
        // NOTE : here what we're setting the params only those who we wanna get updated.

        userRepository.save(user);
        return "User updated Successfully";
    }


    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}
