package com.example.spid.repositories;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

//    void delete(Spid spid);
}
