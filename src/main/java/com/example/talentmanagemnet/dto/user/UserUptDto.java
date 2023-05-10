package com.example.talentmanagemnet.dto.user;


import com.example.talentmanagemnet.dto.GenericDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUptDto extends GenericDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String photoPath;
    private String country;
    private String educationName;
    private String major;
    private String degree;
    private String direction;
    private String skills;
    int testScore;
    private String language;
}
