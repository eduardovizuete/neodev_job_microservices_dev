package com.job.micro.personclient.service;

import com.job.micro.personclient.entity.Person;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long personId);

    Person updatePerson(Person person);

    void deletePerson(Long personId);

}
