package com.Banking_User_Onboard.UserOnboarding.EntryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserEntryDto {

    private int id;
    private String email;
    private String name;
    private int salary;
    private int expense;

}
