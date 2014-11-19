package ru.argus.training;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository {
	private List<Person> persons =  Person.makePersons(10);
	
	
	public List<Person> load() {
		return persons;
	}
	
	public Person load(long personId) {		
		for (Person person : persons) {
			if (person.getId() == personId) return person;
		}
		
		return null;
	}
}
