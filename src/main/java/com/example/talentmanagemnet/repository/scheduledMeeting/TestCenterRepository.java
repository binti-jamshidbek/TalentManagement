package com.example.talentmanagemnet.repository.scheduledMeeting;

import com.example.talentmanagemnet.entity.meeting.testCenter.TestCenter;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestCenterRepository extends JpaRepository<TestCenter, String>, BaseRepository {
    boolean existsByNameAndCountryId(String name, String countryId);

    @Query("select t.name from test_center t where t.countryId =?1")
    Optional<List<String>> findAllNameByCountryId(String countryId);

}
