package com.example.talentmanagemnet.dto.user;

public record UserDto(String firstName, String lastName, String email, String phoneNumber, String photoPath,
                      String country, String educationName, String major, String degree, String direction, String skills,
                      int testScore, String language) {
}
