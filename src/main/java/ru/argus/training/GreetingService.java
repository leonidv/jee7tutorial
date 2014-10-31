package ru.argus.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class GreetingService {
	
	@Inject Messages messages;
	
	public String makeGreeting(String name) {
		return name + " " + messages.getGreeting() + "!";
	}
	
}
