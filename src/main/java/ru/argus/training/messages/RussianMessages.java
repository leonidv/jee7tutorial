package ru.argus.training.messages;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class RussianMessages implements Messages {
	private static final long serialVersionUID = -8882342821958158430L;

	@Override
	public String getGreeting() {	
		return "привет";
	}

}
