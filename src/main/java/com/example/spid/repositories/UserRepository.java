package com.example.spid.repositories;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    Optional<User> findById (Long id);
}
