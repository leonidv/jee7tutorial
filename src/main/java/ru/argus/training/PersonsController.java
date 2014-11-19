package ru.argus.training;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Named
public class PersonsController implements Serializable {
	private static final long serialVersionUID = 2899450189445795897L;

	private Logger log = LoggerFactory.getLogger(PersonsController.class);

	@Inject
	private PersonRepository personRepository;

	private List<Person> persons;

	private String newPersonName = "";

	private String newPersonDocumentSerial = "";

	private String newPersonDocumentNumber = "";

	private Date newPersonBirthdate = null;

	private Person selectedPerson;

	@PostConstruct
	public void sayHello() {
		persons = personRepository.load();
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

	public void validateNewPerson(ComponentSystemEvent event) {
		FacesContext fx = FacesContext.getCurrentInstance();

		UIComponent components = event.getComponent();

		String newSerial = "";
		UIInput serialComponent = (UIInput) components.findComponent("newDocumentSerial");
		if (serialComponent.getLocalValue() != null) {
			newSerial = serialComponent.getLocalValue().toString();
		}

		String newNumber = "";
		UIInput numberComponent = (UIInput) components.findComponent("newDocumentNumber");
		if (numberComponent != null) {
			newNumber = numberComponent.getLocalValue().toString();
		}

		char serialFirstDigit = newSerial.charAt(0);
		char numberFirstDigit = newNumber.charAt(0);

		if (serialFirstDigit != numberFirstDigit) {
			FacesMessage msg = new FacesMessage(
					"Серия документа должна начинаться с той же цифры, что и номер документа");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fx.renderResponse();
		}
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

}
