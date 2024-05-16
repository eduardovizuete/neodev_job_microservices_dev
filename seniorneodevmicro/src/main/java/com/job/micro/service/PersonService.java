package com.job.micro.service;

import com.job.micro.entity.Person;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long personId);

    Person updatePerson(Person person);

    void deletePerson(Long personId);

}
