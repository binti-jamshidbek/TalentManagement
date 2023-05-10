package com.example.talentmanagemnet.entity.meeting.testCenter;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "test_center")
public class TestCenter extends Auditable {
    @Column(nullable = false)
    private String countryId;
    @Column(nullable = false)
    private String name;
    private double latitude;
    private double longitude;

    @Builder(builderMethodName = "child")
    public TestCenter(String id,String countryId, String name, double latitude, double longitude) {
        super(id);
        this.name = name;
        this.countryId = countryId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
