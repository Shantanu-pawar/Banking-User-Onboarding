package com.Banking_User_Onboard.UserOnboarding.Controller;

import com.Banking_User_Onboard.UserOnboarding.EntryDTO.UserEntryDto;
import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.ResponseDto.UserCustomNameEmail;
import com.Banking_User_Onboard.UserOnboarding.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto user) {
        try{
            String response = userService.addUser(user);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("User can not be added.{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCustomUser/{id}")
    public ResponseEntity<String> getCustomUserParams(@PathVariable("id") int id){
        try{
            UserCustomNameEmail userCustomNameEmail = userService.getCustomUser(id);
            return new ResponseEntity(userCustomNameEmail, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("User not able to found" + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserEntryDto user, @PathVariable("id")int id){

        try{
            String response = userService.updateUser(user, id);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            String response = "User is not present so cannot be updated";
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " deleted");
    }
}
