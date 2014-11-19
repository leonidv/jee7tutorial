package ru.argus.training;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
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

	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	public void loadPerson() {
		log.debug("personId = {}", personId);
	}
	
}
