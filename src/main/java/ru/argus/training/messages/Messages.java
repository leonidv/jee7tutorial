package ru.argus.training.messages;

import java.io.Serializable;


public interface Messages extends Serializable {
	
	/**
	 * ¬озвращает приветствие пользователю на его €зыке.
	 * @return
	 */
	public String getGreeting(); 
}
