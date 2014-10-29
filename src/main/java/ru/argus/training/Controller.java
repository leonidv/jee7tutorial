package ru.argus.training;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Named
public class Controller implements Serializable {
	private static final long serialVersionUID = 2899450189445795897L;
	
	Logger log = LoggerFactory.getLogger(Controller.class);
	
	@PostConstruct
	public void sayHello() {
		log.info("hello");
	}
	
	public String getName() {
		return "Ivan";
	}
}
