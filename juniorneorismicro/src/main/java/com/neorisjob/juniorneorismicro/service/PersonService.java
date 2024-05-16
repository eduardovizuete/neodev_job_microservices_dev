package com.neorisjob.juniorneorismicro.service;

import com.neorisjob.juniorneorismicro.entity.Person;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long personId);

    Person updatePerson(Person person);

    void deletePerson(Long personId);

}
