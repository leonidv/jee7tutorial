package ru.argus.training.messages;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class EnglishMessages implements Messages {
	private static final long serialVersionUID = -5637360100408764850L;

	@Override
	public String getGreeting() {
		return "hello";
	}

}
