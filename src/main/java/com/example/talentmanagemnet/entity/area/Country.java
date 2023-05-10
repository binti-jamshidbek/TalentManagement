package com.example.talentmanagemnet.entity.area;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "country")
public class Country extends Auditable {
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;

    @Builder(builderMethodName = "child")
    public Country(String id, String country, String city) {
        super(id);
        this.country = country;
        this.city = city;
    }
}
