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
@Entity(name = "test")
public class Test extends Auditable {
    @Column(nullable = false)
    private String name;
    private int size;
    private int passScore;
    @Column(nullable = false)
    private String time;
    private boolean skill;

    @Builder(builderMethodName = "child")
    public Test(String id, String name, int size, int passScore, String time, boolean skill) {
        super(id);
        this.name = name;
        this.size = size;
        this.passScore = passScore;
        this.time = time;
        this.skill = skill;
    }
}
