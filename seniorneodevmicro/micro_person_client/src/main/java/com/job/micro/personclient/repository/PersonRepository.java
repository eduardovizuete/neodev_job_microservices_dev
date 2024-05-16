package com.job.micro.personclient.repository;

import com.job.micro.personclient.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
