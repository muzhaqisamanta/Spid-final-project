package com.example.spid.repositories;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpidRepository extends JpaRepository<Spid, Long> {
//    @Query("SELECT s from Spid s WHERE s.description LIKE '%?a%'")
//    Optional<Spid> findDscLike(String description);
    Optional<Spid> findSpidByUser(User user);

}
