package com.Banking_User_Onboard.UserOnboarding.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetOnlyNameEmailResponse {

    private String email;
    private String name;
}
