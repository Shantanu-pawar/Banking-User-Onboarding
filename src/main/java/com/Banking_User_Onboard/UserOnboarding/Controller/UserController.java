package com.Banking_User_Onboard.UserOnboarding.Controller;

import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try{
            String response = userService.addUser(user);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "User can not be added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        User user = userService.getUser(id);

        if(user != null) {
            return ResponseEntity.ok(user);
        }
        // if id is not present
        else  return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateEmail(@PathVariable("id")int id, @RequestBody User user){

        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " deleted");
    }
}
