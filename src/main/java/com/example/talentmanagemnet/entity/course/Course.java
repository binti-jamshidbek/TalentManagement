package com.example.talentmanagemnet.entity.course;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "course")
public class Course extends Auditable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String logoPath;
}
