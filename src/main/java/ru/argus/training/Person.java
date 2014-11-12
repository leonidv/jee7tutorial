package ru.argus.training;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Vetoed;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;


@Vetoed
public class Person {
    
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
        
        person.setDocumentNumber(RandomStringUtils.randomNumeric(4));
        person.setDoucmentSerial(RandomStringUtils.randomNumeric(8));
        
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

    public void setDoucmentSerial(String documentSerial) {
        this.documentSerial = documentSerial;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
 
    
    
}
