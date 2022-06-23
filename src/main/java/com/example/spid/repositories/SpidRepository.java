package com.example.spid.repositories;

import com.example.spid.entities.Spid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpidRepository extends JpaRepository<Spid, Long> {
//    @Query("SELECT s from Spid s WHERE s.")
}
