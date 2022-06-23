package com.example.spid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base{
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;
}
