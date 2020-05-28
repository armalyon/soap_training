package com.soap.producer.demo.service;

import com.soap.producer.demo.entity.Person;
import com.soap.producer.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class FillDbService {

    private Person person1 = Person.builder()
            .name("Vasya")
            .surname("Pupkin")
            .build();

    private Person person2 = Person.builder()
            .name("Petya")
            .surname("Vasechkin")
            .build();

    private Person person3 = Person.builder()
            .name("Seryozha")
            .surname("Ivanov")
            .build();

    private Person person4 = Person.builder()
            .name("hello")
            .surname("world")
            .build();


    @Autowired
    private PersonRepository personRepository;


/*
    @PostConstruct
    public void fillDb(){
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        personRepository.saveAll(persons);

    }*/
}
