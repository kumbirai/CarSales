/**
 * za.co.kumbirai.carsales.gui.detail<br>
 * 
 * <p><b>Title:</b> CarDetailView<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 24 Dec 2012 11:52:25 AM
 */
package za.co.kumbirai.carsales.gui.detail;

import java.math.BigDecimal;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import za.co.kumbirai.carsales.entities.Car;
import za.co.kumbirai.carsales.gui.CarSalesMain;
import za.co.kumbirai.carsales.validators.TextInputValidatorPane;
import za.co.kumbirai.carsales.validators.ValidationResult;
import za.co.kumbirai.carsales.validators.Validator;

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
 * <p><b>Title:</b> CarDetailView<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 24 Dec 2012 11:52:25 AM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarDetailView extends GridPane {
	private CarDetailPresenter presenter;
	private Long carId;
	private TextField manufacturerField;
	private TextField modelField;
	private TextField carYearField;
	private TextField priceField;
	private TextField kilometersField;
	private TextArea informationField;

	/**
	 * 
	 */
	public CarDetailView() {
		buildView();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 24 Dec 2012
	 * 
	 * getCar
	 * 
	 * @return
	 */
	public Car getCar() {
		Car car = new Car(manufacturerField.getText(), modelField.getText(), informationField.getText());

		car.setId(carId);
		//car.setModel(modelField.getText());
		car.setCarYear(new Integer(carYearField.getText()));
		car.setPrice(new BigDecimal(priceField.getText()));
		car.setKilometers(new Double(kilometersField.getText()));
		//car.setInformation(informationField.getText());

		return car;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 24 Dec 2012
	 * 
	 * setCar
	 * 
	 * @param car
	 */
	public void setCar(Car car) {
		if (car != null) {
			carId = car.getId();
			manufacturerField.setText(car.getManufacturer().getManufacturer());
			manufacturerField.setDisable(true);
			modelField.setText(car.getModel());
			carYearField.setText(car.getCarYear().toString());
			priceField.setText(car.getPrice().toString());
			kilometersField.setText(car.getKilometers().toString());
			informationField.setText(car.getInformation());
		} else {
			carId = null;
			manufacturerField.setText("");
			manufacturerField.setDisable(false);
			modelField.setText("");
			carYearField.setText("");
			priceField.setText("");
			kilometersField.setText("");
			informationField.setText("");
		}
	}

	/** Setter for the <code>presenter</code> attribute.
	 * @param CarDetailPresenter presenter
	 */
	public void setPresenter(CarDetailPresenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 24 Dec 2012
	 * 
	 * buildView
	 * 
	 */
	protected void buildView() {
		String styleCss = CarSalesMain.class.getResource("styles.css").toExternalForm();
		setHgap(15);
		setVgap(10);
		int row = 0;

		add(new Label("Manufacturer"), 0, row);
		manufacturerField = new TextField();
		manufacturerField.setPrefColumnCount(20);
		manufacturerField.setPromptText("Manufacturer");
		manufacturerField.setMaxHeight(TextField.USE_PREF_SIZE);
		add(manufacturerField, 1, row);

		row++;

		add(new Label("Model"), 0, row);
		modelField = new TextField();
		modelField.setPrefColumnCount(20);
		modelField.setPromptText("Model");
		modelField.setMaxHeight(TextField.USE_PREF_SIZE);
		add(modelField, 1, row);

		row++;

		add(new Label("Year"), 0, row);
		carYearField = new TextField();
		carYearField.setPrefColumnCount(20);
		carYearField.setPromptText("Year");
		carYearField.setMaxHeight(TextField.USE_PREF_SIZE);
		TextInputValidatorPane<TextField> carYearPane = new TextInputValidatorPane<TextField>();
		carYearPane.setContent(carYearField);
		carYearPane.setValidator(new Validator<TextField>() {
			public ValidationResult validate(TextField control) {
				System.out.printf("carYearPane validate text field content: %s\n", control.getText());
				try {
					String text = control.getText();
					if (text == null || text.trim().equals(""))
						return null;
					double d = Double.parseDouble(text);
					if (d < 1996 || d > 2013) {
						ValidationResult result = new ValidationResult("Should be between 1996 and 2013", ValidationResult.Type.WARNING);
						System.out.printf("validation message = %s, validation type = %s\n", result.getMessage(), result.getType());
						return result;
					}
					return null; // succeeded
				} catch (Exception e) {
					// failed
					return new ValidationResult("Bad number", ValidationResult.Type.ERROR);
				}
			}
		});
		carYearPane.getStylesheets().add(styleCss);
		add(carYearField, 1, row);

		row++;

		add(new Label("Milage"), 0, row);
		kilometersField = new TextField();
		kilometersField.setPrefColumnCount(20);
		kilometersField.setPromptText("Milage");
		kilometersField.setMaxHeight(TextField.USE_PREF_SIZE);
		add(kilometersField, 1, row);

		row++;

		add(new Label("Price"), 0, row);
		priceField = new TextField();
		priceField.setPrefColumnCount(20);
		priceField.setPromptText("Price");
		priceField.setMaxHeight(TextField.USE_PREF_SIZE);
		add(priceField, 1, row);

		row++;

		add(new Label("Information"), 0, row);
		informationField = new TextArea();
		informationField.setPrefColumnCount(20);
		informationField.setPrefRowCount(4);
		informationField.setPromptText("Information");
		informationField.setMaxHeight(TextField.USE_PREF_SIZE);
		add(informationField, 1, row);

		row++;

		HBox buttonBar = new HBox(10);

		Button saveButton = new Button("Save");
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				saveButtonClicked();
			}
		});
		buttonBar.getChildren().add(saveButton);

		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				presenter.delete();
			}
		});
		buttonBar.getChildren().add(deleteButton);

		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				presenter.cancel();
			}
		});
		buttonBar.getChildren().add(cancelButton);

		add(buttonBar, 0, row, 1, 2);

		row++;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * saveButtonClicked
	 * 
	 */
	protected void saveButtonClicked() {
		String manufacturer = "";
		String model = "";
		String info = "";
		Double kilometers = 0D;
		BigDecimal price = new BigDecimal(0);
		Integer year = 0;

		boolean valid = false;

		try {
			/*
			 * retrieve all the values from the text field, and convert them
			 * into an appropriate format
			 */
			manufacturer = manufacturerField.getText().trim();
			model = modelField.getText().trim();
			info = informationField.getText().trim();
			kilometers = Double.parseDouble(kilometersField.getText().trim());
			price = new BigDecimal(priceField.getText().trim());
			year = Integer.parseInt(carYearField.getText().trim());
		} catch (NumberFormatException ex) {
			System.err.println("CarDetailView#saveButtonClicked Failed with an Exception [NumberFormatException] - " + ex.toString());
		}

		// begin validation process
		if (year >= 1000 && year <= 9999) {
			if (validateKilometers(kilometers.toString())) {
				valid = true;
			}
		}

		if (valid) {
			// create a car object from validated data.
			Car myCar = new Car(manufacturer, model, info);
			myCar.setId(carId);
			myCar.setKilometers(kilometers);
			myCar.setPrice(price);
			myCar.setCarYear(year);

			// attempt to add the new car to the system.
			presenter.save(myCar);
		}
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * validateKilometers
	 * 
	 * @param distance
	 * @return
	 */
	protected boolean validateKilometers(String distance) {
		boolean valid = false;
		String rem;
		StringTokenizer tokens = new StringTokenizer(distance, "."); // look for decimal point

		tokens.nextToken();

		if (tokens.hasMoreTokens()) // if true, there is a decimal point present
		{
			// get string representation of all numbers after the decimal point
			rem = tokens.nextToken();
			// if there's only one number after the decimal point, then it's valid
			if (rem.length() == 1)
				valid = true;
			else {
				// check if the user has typed something like 3.00, or even 3.00000
				if ((Integer.parseInt(rem)) % (Math.pow(10, rem.length() - 1)) == 0)
					valid = true;
				else
					valid = false;
			}
		} else
			// doesn't have a decimal place
			valid = true;

		return valid;
	}
}