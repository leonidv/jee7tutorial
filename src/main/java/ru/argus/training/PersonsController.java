package ru.argus.training;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Named
public class PersonsController implements Serializable {
    private static final long serialVersionUID = 2899450189445795897L;

    private Logger log = LoggerFactory.getLogger(PersonsController.class);

    private List<Person> persons = Person.makePersons(10);

    @PostConstruct
    public void sayHello() {
        log.info("hello");
    }

    public String getName() {
        return "Ivan";
    }

    public List<Person> getPersons() {
        return persons;
    }

}
