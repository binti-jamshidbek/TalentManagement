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
@Entity(name = "answer")
public class Answer extends Auditable {
    @Column(nullable = false)
    private String questionId;
    @Column(nullable = false)
    private String answer;
    private boolean correct;

    @Builder(builderMethodName = "child")
    public Answer(String id, String questionId, String answer, boolean correct) {
        super(id);
        this.questionId = questionId;
        this.answer = answer;
        this.correct = correct;
    }
}
