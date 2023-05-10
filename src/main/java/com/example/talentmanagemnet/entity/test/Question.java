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
@Entity(name = "question")
public class Question extends Auditable {
    @Column(nullable = false)
    private String testId;
    @Column(nullable = false)
    private String question;

    @Builder(builderMethodName = "child")
    public Question(String id, String testId, String question) {
        super(id);
        this.testId = testId;
        this.question = question;
    }
}
