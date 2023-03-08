package tech.getarrays.RentowniaBackendDemo.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.RentowniaBackendDemo.model.Person;
import tech.getarrays.RentowniaBackendDemo.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = personService.getAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
