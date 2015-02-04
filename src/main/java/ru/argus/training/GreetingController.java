package ru.argus.training;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Named
public class GreetingController implements Serializable {
	private static final long serialVersionUID = 2899450189445795897L;
	
	Logger log = LoggerFactory.getLogger(GreetingController.class);
	
	private String name = "";
	
	@Inject GreetingService greetingService;
	
	@Inject
	Event<ChangeNameEvent> changeNameEvent;
	
	public void setName(String name) {
		ChangeNameEvent cne = new ChangeNameEvent(this.name, name);
		changeNameEvent.fire(cne);		
		this.name = name;
	}
	
	public void changeName() {

		log.info("name is changed = "+name);
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getGreeting() {
		return greetingService.makeGreeting(name);
	}
}