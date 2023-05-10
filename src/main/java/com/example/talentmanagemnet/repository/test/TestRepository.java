package com.example.talentmanagemnet.repository.test;

import com.example.talentmanagemnet.entity.test.Test;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TestRepository extends JpaRepository<Test, String>, BaseRepository {

    Optional<Test> findByName(String name);

    @Query("select t.name from test t where t.skill")
    List<String> findAllDirections();

    boolean existsByName(String name);
}
