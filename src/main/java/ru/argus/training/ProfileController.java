package ru.argus.training;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.commons.lang3.StringUtils.*;

@SessionScoped
@Named
public class ProfileController implements Serializable{
	private static final long serialVersionUID = -8704221720959344115L;

	private final static Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	private String name;

	private List<String> nameHistory = new ArrayList<>();
	
	public void onNameChanged(@Observes ChangeNameEvent event) {
		logger.info("name is changed " + event);
		
		String oldValue = event.getOldValue();		
		if (isNotBlank(oldValue)) {
			nameHistory.add(oldValue);
		}
		
		name = event.getNewValue();
	}
	
	public String getName() {
		return name;
	}

	public boolean showHistory() {
		return !nameHistory.isEmpty();
	}

	public List<String> getNameHistory() {
		return nameHistory;
	}
	
}
