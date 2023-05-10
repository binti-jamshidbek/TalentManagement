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
@Entity(name = "education")
public class Education extends Auditable {
    @Column(nullable = false)
    private String authUserId;
    @Column(nullable = false)
    private String education;
    @Column(nullable = false)
    private String school;
    @Column(nullable = false)
    private String degree;
    @Column(nullable = false)
    private String startDate;
    private String endDate;
    private boolean present;
    @Column(nullable = false)
    private String description;

    @Builder(builderMethodName = "child")
    public Education(String id, String authUserId, String education, String school, String degree, String startDate, String endDate, boolean present, String description) {
        super(id);
        this.authUserId = authUserId;
        this.education = education;
        this.school = school;
        this.degree = degree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.present = present;
        this.description = description;
    }
}
