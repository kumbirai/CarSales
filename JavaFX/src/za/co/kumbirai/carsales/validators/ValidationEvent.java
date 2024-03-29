/**
 * za.co.kumbirai.carsales.validators<br>
 * 
 * <p><b>Title:</b> ValidationEvent<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 28 Dec 2012 1:48:21 PM
 */
package za.co.kumbirai.carsales.validators;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * <p><b>Purpose:</b><br>
 * <br>
 *
 * Copyright Notice<br>
 * ================<br>
 * This file contains proprietary information.
 * Copying or reproduction without prior written approval is prohibited.<br>
 * Copyright (c) 2012<br>
 * 
 * <p><b>Title:</b> ValidationEvent<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 28 Dec 2012 1:48:21 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class ValidationEvent extends Event {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8103061226200238449L;

	public static final EventType<ValidationEvent> ANY = new EventType<ValidationEvent>(Event.ANY, "VALIDATION");

	private final ValidationResult result;

	public ValidationEvent(ValidationResult result) {
		super(ANY);
		this.result = result;
	}

	public final ValidationResult getResult() {
		return result;
	}
}