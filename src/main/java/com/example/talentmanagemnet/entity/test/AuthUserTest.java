package com.example.talentmanagemnet.entity.test;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "auth_user_test")
public class AuthUserTest extends Auditable {
    @Column(nullable = false)
    private String authUserId;
    @Column(nullable = false)
    private String testId;
    private int score;
    private int testSize;
    private String description;

    @Builder(builderMethodName = "child")
    public AuthUserTest(String id, String authUserId, String testId, int score, int testSize, String description) {
        super(id);
        this.authUserId = authUserId;
        this.testId = testId;
        this.score = score;
        this.testSize = testSize;
        this.description = description;
    }
}
