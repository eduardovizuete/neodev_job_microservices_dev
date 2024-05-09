package com.neorisjob.juniorneorismicro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends Person {

    @Column(nullable = false, unique = true)
    private String clientId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String status;

}
