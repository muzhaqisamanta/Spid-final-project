package com.example.spid.entities;

import com.example.spid.entities.enums.Status;
import com.example.spid.entities.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "spid")
@Data
public class Spid extends Base{
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
