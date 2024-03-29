/**
 * za.co.kumbirai.carsales.model<br>
 * 
 * <p><b>Title:</b> CarModel<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 20 Dec 2012 3:02:14 PM
 */
package za.co.kumbirai.carsales.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
 * <p><b>Title:</b> CarModel<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 20 Dec 2012 3:02:14 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarModel {
	private LongProperty id;
	private StringProperty manufacturer;
	private StringProperty model;
	private StringProperty information;
	private IntegerProperty carYear;
	private DoubleProperty price;
	private DoubleProperty kilometers;

	/**
	 * 
	 */
	public CarModel() {
	}

	/**
	 * @param car
	 */
	public CarModel(Car car) {
		setId(car.getId());
		setManufacturer(car.getManufacturer().getManufacturer());
		setModel(car.getModel());
		setInformation(car.getInformation());
		setCarYear(car.getCarYear());
		setPrice(car.getPrice().doubleValue());
		setKilometers(car.getKilometers());
	}

	/** Getter for the <code>id</code> attribute.
	 * @return Long - value of the attribute <code>id</code>.
	 */
	public Long getId() {
		return idProperty().get();
	}

	/** Setter for the <code>id</code> attribute.
	 * @param Long id
	 */
	public void setId(Long id) {
		idProperty().set(id);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * idProperty
	 * 
	 * @return
	 */
	public LongProperty idProperty() {
		if (id == null)
			id = new SimpleLongProperty(this, "id");
		return id;
	}

	/** Getter for the <code>manufacturer</code> attribute.
	 * @return String - value of the attribute <code>manufacturer</code>.
	 */
	public String getManufacturer() {
		return manufacturerProperty().get();
	}

	/** Setter for the <code>manufacturer</code> attribute.
	 * @param String manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		manufacturerProperty().set(manufacturer);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * manufacturerProperty
	 * 
	 * @return
	 */
	public StringProperty manufacturerProperty() {
		if (manufacturer == null)
			manufacturer = new SimpleStringProperty(this, "manufacturer");
		return manufacturer;
	}

	/** Getter for the <code>model</code> attribute.
	 * @return String - value of the attribute <code>model</code>.
	 */
	public String getModel() {
		return modelProperty().get();
	}

	/** Setter for the <code>model</code> attribute.
	 * @param String model
	 */
	public void setModel(String model) {
		modelProperty().set(model);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * modelProperty
	 * 
	 * @return
	 */
	public StringProperty modelProperty() {
		if (model == null)
			model = new SimpleStringProperty(this, "model");
		return model;
	}

	/** Getter for the <code>information</code> attribute.
	 * @return String - value of the attribute <code>information</code>.
	 */
	public String getInformation() {
		return informationProperty().get();
	}

	/** Setter for the <code>information</code> attribute.
	 * @param String information
	 */
	public void setInformation(String information) {
		informationProperty().set(information);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * informationProperty
	 * 
	 * @return
	 */
	public StringProperty informationProperty() {
		if (information == null)
			information = new SimpleStringProperty(this, "information");
		return information;
	}

	/** Getter for the <code>carYear</code> attribute.
	 * @return Integer - value of the attribute <code>carYear</code>.
	 */
	public Integer getCarYear() {
		return carYearProperty().get();
	}

	/** Setter for the <code>carYear</code> attribute.
	 * @param Integer carYear
	 */
	public void setCarYear(Integer carYear) {
		carYearProperty().set(carYear);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * carYearProperty
	 * 
	 * @return
	 */
	public IntegerProperty carYearProperty() {
		if (carYear == null)
			carYear = new SimpleIntegerProperty(this, "carYear");
		return carYear;
	}

	/** Getter for the <code>price</code> attribute.
	 * @return BigDecimal - value of the attribute <code>price</code>.
	 */
	public Double getPrice() {
		return priceProperty().get();
	}

	/** Setter for the <code>price</code> attribute.
	 * @param BigDecimal price
	 */
	public void setPrice(Double price) {
		priceProperty().set(price);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * priceProperty
	 * 
	 * @return
	 */
	public DoubleProperty priceProperty() {
		if (price == null)
			price = new SimpleDoubleProperty(this, "price");
		return price;
	}

	/** Getter for the <code>kilometers</code> attribute.
	 * @return Double - value of the attribute <code>kilometers</code>.
	 */
	public Double getKilometers() {
		return kilometersProperty().get();
	}

	/** Setter for the <code>kilometers</code> attribute.
	 * @param Double kilometers
	 */
	public void setKilometers(Double kilometers) {
		kilometersProperty().set(kilometers);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * kilometersProperty
	 * 
	 * @return
	 */
	public DoubleProperty kilometersProperty() {
		if (kilometers == null)
			kilometers = new SimpleDoubleProperty(this, "kilometers");
		return kilometers;
	}
}