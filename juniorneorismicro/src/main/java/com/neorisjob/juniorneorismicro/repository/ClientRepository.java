package com.neorisjob.juniorneorismicro.repository;

import com.neorisjob.juniorneorismicro.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByClientId(Long clientId);

}
