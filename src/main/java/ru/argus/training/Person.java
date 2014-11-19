package ru.argus.training;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Vetoed;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;


@Vetoed
public class Person implements Serializable {
	private static final long serialVersionUID = 4753704699017664953L;

	public static List<Person> makePersons(int count) {
        List<Person> persons = new ArrayList<Person>(count);
        for (int i =0; i < count; i++) {
            persons.add(generatePerson());
        }
        
        return persons;
    }
    
    public static Person generatePerson() {
        Person person = new Person();
        person.setFirstName(generateName());;
        person.setMiddleName(generateName());
        person.setLastName(generateName());
        

        person.setBirthdate(generateDate());
        
        person.setDocumentNumber(RandomStringUtils.randomNumeric(6));
        person.setDocumentSerial(RandomStringUtils.randomNumeric(4));
        
        return person;
    }
    
    private static String generateName() {
        String name = RandomStringUtils.randomAlphabetic(15).toLowerCase();
        return StringUtils.capitalize(name);
    }
    
    private static Date generateDate() {
        int year = RandomUtils.nextInt(1950, 1998);
        int day = RandomUtils.nextInt(1, 356);
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, day);
        
        return calendar.getTime();
    }
    
    private static long counter = 1;
    
    private long id = counter++;
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    private Date birthdate;
    
    private String documentNumber;
    
    private String documentSerial;

    private List<Card> cards = new ArrayList<>();
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentSerial() {
        return documentSerial;
    }

    public void setDocumentSerial(String documentSerial) {
        this.documentSerial = documentSerial;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
 
	
}
