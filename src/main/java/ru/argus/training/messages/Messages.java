package ru.argus.training.messages;

import java.io.Serializable;


public interface Messages extends Serializable {
	
	/**
	 * ���������� ����������� ������������ �� ��� �����.
	 * @return
	 */
	public String getGreeting(); 
}
