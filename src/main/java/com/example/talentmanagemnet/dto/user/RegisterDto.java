package com.example.talentmanagemnet.dto.user;

public record RegisterDto(String firstName, String lastName, String email, String phoneNumber, String password,
                          String educationName, String country, String major, String degree, String direction,
                          String skills, int testScore, String language) {


}
