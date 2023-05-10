package com.example.talentmanagemnet.entity.inforamation;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "experience")
public class Experience extends Auditable {
    @Column(nullable = false)
    private String authUserId;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String employer;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String startDate;
    private String endDate;
    private boolean present;
    @Column(nullable = false)
    private String description;

    @Builder(builderMethodName = "child")
    public Experience(String id, String authUserId, String position, String employer, String city, String startDate, String endDate, boolean present, String description) {
        super(id);
        this.authUserId = authUserId;
        this.position = position;
        this.employer = employer;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.present = present;
        this.description = description;
    }
}
