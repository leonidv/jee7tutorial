package ru.argus.training;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@ConversationScoped
@Named
public class PersonController implements Serializable {
	private static final long serialVersionUID = 577187480897975134L;


	private Logger log = LoggerFactory.getLogger(PersonsController.class);
	
	private long personId;

	private Person person;
	
	@Inject
	private PersonRepository personRepository;
	
	@PostConstruct
	public void logPostConstruct() {
		log.debug("post construct< person id = {}", personId);
	}
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		log.debug("set person id = {}", personId);
		this.personId = personId;
	}
	
	public void loadPerson() {
		log.debug("load person");
		person = personRepository.load(personId);
	}
	
	public String getFullName() {
		return person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName();
	}
}
