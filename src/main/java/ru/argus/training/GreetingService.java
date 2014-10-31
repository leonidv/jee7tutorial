package ru.argus.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ru.argus.training.messages.Messages;


@ApplicationScoped
public class GreetingService {
	
	@Inject Messages messages;
	
	public String makeGreeting(String name) {
		return name + " " + messages.getGreeting() + "!";
	}
	
}
