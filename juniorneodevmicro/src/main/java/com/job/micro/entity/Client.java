package com.job.micro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "clientId", nullable = false, unique = true)
    private Long clientId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @JsonIgnoreProperties(value = { "client", "transactions" }, allowSetters = true)
    private Set<Account> accounts = new HashSet<>();

}
