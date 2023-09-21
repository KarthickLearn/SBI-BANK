package com.sbi.userdetails.service.UserDetailsService.userdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String userName;
    private String emailId;
    private String password;
    private Long phoneNumber;
    private Long alternativePhoneNumber;
    private Long doorNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
