package com.example.spid.repositories;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpidRepository extends JpaRepository<Spid, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM public.spid WHERE description LIKE %:keyword% ")
    List<Spid> searchSpid(@Param("keyword") String keyword);

}
