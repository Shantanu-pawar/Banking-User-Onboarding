package com.Banking_User_Onboard.UserOnboarding.Service;

import com.Banking_User_Onboard.UserOnboarding.EntryDTO.UserEntryDto;
import com.Banking_User_Onboard.UserOnboarding.Models.User;
import com.Banking_User_Onboard.UserOnboarding.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    // purpose is to close all resources when the entire class execution get finished.
    AutoCloseable autoCloseable;

    User user;
    UserEntryDto userEntryDto;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        user = new User(1, "dadu@gmail.com", "name",
                25000, 1200);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void addUser() {
        mock(UserEntryDto.class);
        mock(UserRepository.class);
//
//        when(userRepository.save(userEntryDto)).thenReturn(userEntryDto);
//        assertThat(userService.addUser(userEntryDto)).isEqualTo("user added successfully");
    }

    @Test
    void getUser() {
    }

    @Test
    void getCustomUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
//
//
//    @InjectMocks
//    UserService userService;
//    @Mock
//    UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        userService = new UserService();
//        userRepository = mock(UserRepository.class);
//    }

//    @Test
//    void fun(){
//        UserEntryDto userEntryDto =
//                new UserEntryDto("ram@gmail.com", "raj", 31000, 1200);
//
//        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
//
//        when(userRepository.save(any())).thenReturn(mock(User.class));
//        String res = userService.addUser(userEntryDto);
//
//        verify(userRepository, times(1)).save(any());
//
//    }