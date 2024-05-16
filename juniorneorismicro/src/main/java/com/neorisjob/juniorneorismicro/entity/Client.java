package com.neorisjob.juniorneorismicro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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

//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
//    @JsonIgnoreProperties(value = { "client" }, allowSetters = true)
//    private Set<Account> accounts = new HashSet<>();

}
