package tech.getarrays.RentowniaBackendDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.RentowniaBackendDemo.model.Person;
import tech.getarrays.RentowniaBackendDemo.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public Person getPersonById(Long personId){ //implement exception if record not exists
        return personRepository.getReferenceById(personId);
    }
    public List<Person> getAllPersons(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }
    public Person updatePerson(Person person){
        return personRepository.save(person);
    }
    public void deletePersonById(Long personId){ //implement exception if record not exists
        personRepository.deleteById(personId);
    }
}
