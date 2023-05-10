package com.example.talentmanagemnet.entity.user;

import com.example.talentmanagemnet.entity.Auditable;
import com.example.talentmanagemnet.enums.Degree;
import com.example.talentmanagemnet.enums.Direction;
import com.example.talentmanagemnet.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "auth_user")
public class AuthUser extends Auditable {
    @Column(nullable = false)
    private String firstName;

    private String photoPath;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private String educationName;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Column(nullable = false)
    private String skills;

    private int testScore;

    @Column(nullable = false)
    private String language;

    @Builder(builderMethodName = "child")
    public AuthUser(String id, String firstName, String photoPath, String lastName, String email, String password, String phoneNumber, String country, UserRole role, String educationName, String major, Degree degree, Direction direction, String skills, int testScore, String language) {
        super(id);
        this.firstName = firstName;
        this.photoPath = photoPath;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.role = role;
        this.educationName = educationName;
        this.major = major;
        this.degree = degree;
        this.direction = direction;
        this.skills = skills;
        this.testScore = testScore;
        this.language = language;
    }
}

