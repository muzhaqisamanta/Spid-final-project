package com.example.spid.entities;

import com.example.spid.entities.enums.Status;
import com.example.spid.entities.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spid")
@Data
public class Spid extends Base{
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
