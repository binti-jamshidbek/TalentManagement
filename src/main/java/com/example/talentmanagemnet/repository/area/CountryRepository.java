package com.example.talentmanagemnet.repository.area;

import com.example.talentmanagemnet.entity.area.Country;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,String>, BaseRepository {

    boolean existsByCityAndCountry(String city, String country);
}
