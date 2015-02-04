package ru.argus.training;

import java.io.Serializable;

public class ChangeNameEvent implements Serializable {
	private static final long serialVersionUID = -8807771553319073145L;
	
	private final String oldValue;
	
	private final String newValue;

	public ChangeNameEvent(String oldValue, String newValue) {
		super();
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public String getOldValue() {
		return oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	@Override
	public String toString() {
		return "ChangeNameEvent [oldValue=" + oldValue + ", newValue=" + newValue + "]";
	}
	
}
