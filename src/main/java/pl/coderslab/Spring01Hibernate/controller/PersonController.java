package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.dao.PersonDao;
import pl.coderslab.Spring01Hibernate.model.Person;
import pl.coderslab.Spring01Hibernate.model.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Maciej");
        personDetails.setLastName("Kowalski");
        personDetails.setCity("Warszawa");
        personDetails.setStreet("Prosta");
        personDetails.setStreetNumber("45C");

        Person person = new Person();
        person.setLogin("test");
        person.setPassword("test123");
        person.setEmail("test@o2.pl");
        person.setPersonDetails(personDetails);

        personDao.persist(person);

        return person.toString();
    }

    @GetMapping("/merge")
    @ResponseBody
    public String merge() {
        Person person = personDao.findById(1L);
        person.setLogin("owyLogin");
        person.getPersonDetails().setLastName("Nowe Nazwisko");

        personDao.merge(person);

        return person.toString();
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        personDao.removeById(id);
        return "Usunieto poymslnie";
    }

}
