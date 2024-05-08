package com.neorisjob.juniorneorismicro.repository;

import com.neorisjob.juniorneorismicro.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
