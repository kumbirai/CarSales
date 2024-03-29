/**
 * za.co.kumbirai.carsales.validators<br>
 * 
 * <p><b>Title:</b> ValidationResult<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 28 Dec 2012 1:47:10 PM
 */
package za.co.kumbirai.carsales.validators;

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
 * <p><b>Title:</b> ValidationResult<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 28 Dec 2012 1:47:10 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class ValidationResult {
	public enum Type {
		ERROR, WARNING, SUCCESS
	}
	private final String message;
	private final Type type;

	public ValidationResult(String message, Type type) {
		this.message = message;
		this.type = type;
	}

	public final String getMessage() {
		return message;
	}

	public final Type getType() {
		return type;
	}
}
