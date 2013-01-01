/**
 * za.co.kumbirai.carsales.validators<br>
 * 
 * <p><b>Title:</b> TextInputValidatorPane<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 28 Dec 2012 1:38:56 PM
 */
package za.co.kumbirai.carsales.validators;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextInputControl;

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
 * <p><b>Title:</b> TextInputValidatorPane<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 28 Dec 2012 1:38:56 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class TextInputValidatorPane<C extends TextInputControl> extends ValidatorPane<C> {

	private InvalidationListener textListener = new InvalidationListener() {
		@Override
		public void invalidated(Observable o) {
			final Validator v = getValidator();
			final ValidationResult result = v != null ? v.validate(getContent()) : new ValidationResult("", ValidationResult.Type.SUCCESS);
			handleValidationResult(result);
		}
	};

	public TextInputValidatorPane() {
		contentProperty().addListener(new ChangeListener<C>() {
			@Override
			public void changed(ObservableValue<? extends C> ov, C oldValue, C newValue) {
				if (oldValue != null)
					oldValue.textProperty().removeListener(textListener);
				if (newValue != null)
					newValue.textProperty().addListener(textListener);
			}
		});
	}

	public TextInputValidatorPane(C field) {
		this();
		setContent(field);
	}
}
