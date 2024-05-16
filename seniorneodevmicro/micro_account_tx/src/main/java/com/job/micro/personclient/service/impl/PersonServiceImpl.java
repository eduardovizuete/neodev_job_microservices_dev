package com.job.micro.personclient.service.impl;

import com.job.micro.personclient.entity.Person;
import com.job.micro.personclient.repository.PersonRepository;
import com.job.micro.personclient.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.get();
    }

    @Override
    public Person updatePerson(Person person) {
        Person existingPerson = personRepository.findById(person.getId()).get();
        existingPerson.setName(person.getName());
        existingPerson.setGender(person.getGender());
        existingPerson.setAge(person.getAge());
        existingPerson.setIdentification(person.getIdentification());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setTelephone(person.getTelephone());

        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

}
