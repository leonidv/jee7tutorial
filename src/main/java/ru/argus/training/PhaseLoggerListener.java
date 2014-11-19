package ru.argus.training;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhaseLoggerListener implements PhaseListener {
	
	private Logger log = LoggerFactory.getLogger(PersonsController.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		String phase = StringUtils.rightPad(event.getPhaseId().toString(), 23);
		log.debug(">>>>>>>>>>>>>>> {} | source = {} ",phase, event.getSource());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		String phase = StringUtils.rightPad(event.getPhaseId().toString(), 23);
		log.debug("<<<<<<<<<<<<<<< {} | source = {} ",phase, event.getSource());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
