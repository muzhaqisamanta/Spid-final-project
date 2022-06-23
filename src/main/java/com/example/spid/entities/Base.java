package com.example.spid.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public LocalDateTime createdAt = LocalDateTime.now();
    @CreatedBy
    public String createdBy;


}
