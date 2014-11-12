package ru.argus.training;

import java.io.Serializable;
import java.util.Date;
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
    
    private String newPersonName = "";

    private String newPersonDocumentSerial = "";
    
    private String newPersonDocumentNumber = "";
    
    private Date newPersonBirthdate = null;
    
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

	public String getNewPersonName() {
		return newPersonName;
	}

	public void setNewPersonName(String newPersonName) {
		this.newPersonName = newPersonName;
	}

	public String getNewPersonDocumentSerial() {
		return newPersonDocumentSerial;
	}

	public void setNewPersonDocumentSerial(String newPersonDocumentSerial) {
		this.newPersonDocumentSerial = newPersonDocumentSerial;
	}

	public String getNewPersonDocumentNumber() {
		return newPersonDocumentNumber;
	}

	public void setNewPersonDocumentNumber(String newPersonDocumentNumber) {
		this.newPersonDocumentNumber = newPersonDocumentNumber;
	}

	public Date getNewPersonBirthdate() {
		return newPersonBirthdate;
	}

	public void setNewPersonBirthdate(Date newPersonBirthdate) {
		this.newPersonBirthdate = newPersonBirthdate;
	}

	public void addPerson() {
		Person person = new Person();
		String[] names = newPersonName.split("\\s+");
		person.setLastName(names[0]);
		person.setFirstName(names[1]);
		person.setMiddleName(names[2]);
		
		person.setBirthdate(newPersonBirthdate);
		
		person.setDocumentNumber(newPersonDocumentNumber);
		person.setDocumentSerial(newPersonDocumentSerial);
		
		persons.add(0, person);
		
		newPersonName = "";
		newPersonDocumentNumber = "";
		newPersonDocumentSerial = "";
		newPersonBirthdate = null;
	}
}
