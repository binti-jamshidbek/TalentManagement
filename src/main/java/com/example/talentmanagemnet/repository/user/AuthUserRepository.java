package com.example.talentmanagemnet.repository.user;

import com.example.talentmanagemnet.entity.user.AuthUser;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,String>, BaseRepository {
    Optional<AuthUser> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String email);
    boolean existsByPhoneNumberAndEmail(String phone, String email);
}
