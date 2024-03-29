/**
 * za.co.kumbirai.carsales.validators<br>
 * 
 * <p><b>Title:</b> Validator<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 28 Dec 2012 1:45:43 PM
 */
package za.co.kumbirai.carsales.validators;

import javafx.scene.control.Control;

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
 * <p><b>Title:</b> Validator<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 28 Dec 2012 1:45:43 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public interface Validator<C extends Control> {
	public ValidationResult validate(C control);
}