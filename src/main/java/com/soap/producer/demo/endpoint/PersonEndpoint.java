package com.soap.producer.demo.endpoint;

import com.soap.producer.demo.entity.Person;
import com.soap.producer.demo.repository.PersonRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import training.soap.GetPersonRequest;
import training.soap.GetPersonResponse;
import training.soap.ObjectFactory;

import javax.annotation.Resource;
import java.util.Optional;

@Endpoint
public class PersonEndpoint {

    private final static String NAMESPACE_URI = "http://soap.training";

    @Resource
    private PersonRepository personRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetPersonResponse response = objectFactory.createGetPersonResponse();

        Optional<Person> personOptional = personRepository.findBySurname(request.getSurname());
        if (personOptional.isPresent()) {
            Person personFromRepo = personOptional.get();
            training.soap.Person person = objectFactory.createPerson();
            person.setId((int) personFromRepo.getId());
            person.setName(personFromRepo.getName());
            person.setSurname(personFromRepo.getSurname());

            response.setPerson(person);
            return response;
        }
        return null;
    }
}
