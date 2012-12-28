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

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import za.co.kumbirai.carsales.entities.Car;

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
	private TextField informationField;

	/**
	 * 
	 */
	public CarDetailView() {
	}

	public Car getCar() {
		Car car = new Car();

		car.setId(carId);
		car.setModel(modelField.getText());
		car.setCarYear(new Integer(carYearField.getText()));
		car.setPrice(new BigDecimal(priceField.getText()));
		car.setKilometers(new Double(kilometersField.getText()));
		car.setInformation(informationField.getText());

		return car;
	}

	public void setCar(Car car) {
		if (car != null) {
			carId = car.getId();
			manufacturerField.setText(car.getManufacturer().getManufacturer());
			modelField.setText(car.getModel());
			carYearField.setText(car.getCarYear().toString());
			priceField.setText(car.getPrice().toString());
			kilometersField.setText(car.getKilometers().toString());
			informationField.setText(car.getInformation());
		} else {
			carId = 0L;
			manufacturerField.setText("");
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

	protected void buildView() {
		setHgap(10);
		setVgap(10);
		int row = 0;

		add(new Label("Manufacturer"), 0, row);
		manufacturerField = new TextField();
		manufacturerField.setPrefColumnCount(20);
		add(manufacturerField, 1, row);

		row++;

		add(new Label("Model"), 0, row);
		modelField = new TextField();
		modelField.setPrefColumnCount(20);
		add(modelField, 1, row);

		row++;

		add(new Label("Year"), 0, row);
		carYearField = new TextField();
		carYearField.setPrefColumnCount(20);
		add(carYearField, 1, row);

		row++;

		add(new Label("Price"), 0, row);
		priceField = new TextField();
		priceField.setPrefColumnCount(20);
		add(priceField, 1, row);

		row++;

		add(new Label("Milage"), 0, row);
		kilometersField = new TextField();
		kilometersField.setPrefColumnCount(20);
		add(kilometersField, 1, row);

		row++;

		add(new Label("Information"), 0, row);
		informationField = new TextField();
		informationField.setPrefColumnCount(20);
		add(informationField, 1, row);

		row++;
	}
}
