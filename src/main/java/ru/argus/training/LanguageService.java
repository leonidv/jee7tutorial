package ru.argus.training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import ru.argus.training.messages.Messages;
import ru.argus.training.messages.RussianMessages;

/**
 * ��������� ��������� ����������� ����������.
 * @author l.vygovsky
 *
 */
@ApplicationScoped
public class LanguageService {
	
	@SessionScoped @Produces Messages createMessages() {
		return new RussianMessages();
	}
}
