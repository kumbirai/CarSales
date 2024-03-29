/**
 * za.co.kumbirai.carsales.gui.summary<br>
 * 
 * <p><b>Title:</b> CarSummaryView<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 20 Dec 2012 12:15:24 PM
 */
package za.co.kumbirai.carsales.gui.summary;

import java.util.Map;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import za.co.kumbirai.carsales.StatisticType;

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
 * <p><b>Title:</b> CarSummaryView<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 20 Dec 2012 12:15:24 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSummaryView extends GridPane {
	private CarSummaryPresenter presenter;
	private IntegerProperty carCount = new SimpleIntegerProperty(0);
	private IntegerProperty manuCount = new SimpleIntegerProperty(0);
	private DoubleProperty avgPrice = new SimpleDoubleProperty(0);
	private DoubleProperty avgDist = new SimpleDoubleProperty(0);
	private DoubleProperty avgAge = new SimpleDoubleProperty(0);

	/**
	 * 
	 */
	public CarSummaryView() {
		buildView();
	}

	protected void buildView() {
		setHgap(10);
		setVgap(10);
		int row = 0;

		add(new Label("Total number of cars:"), 0, row);
		Text carCountText = new Text();
		carCountText.textProperty().bind(carCount.asString());
		add(carCountText, 1, row);

		row++;

		add(new Label("Total number of manufacturers:"), 0, row);
		Text manuCountText = new Text();
		manuCountText.textProperty().bind(manuCount.asString());
		add(manuCountText, 1, row);

		row++;

		add(new Label("Average price:"), 0, row);
		Text avgPriceText = new Text();
		avgPriceText.textProperty().bind(avgPrice.asString("%,.2f"));
		add(avgPriceText, 1, row);

		row++;

		add(new Label("Average milage:"), 0, row);
		Text avgDistText = new Text();
		avgDistText.textProperty().bind(avgDist.asString("%,.0f"));
		add(avgDistText, 1, row);

		row++;

		add(new Label("Average age:"), 0, row);
		Text avgAgeText = new Text();
		avgAgeText.textProperty().bind(avgAge.asString("%,.1f"));
		add(avgAgeText, 1, row);

		row++;
	}

	/** Setter for the <code>stats</code> attribute.
	 * @param Map<StatisticType,Double> stats
	 */
	public void setStats(Map<StatisticType, Double> stats) {
		for (Map.Entry<StatisticType, Double> entry : stats.entrySet()) {
			switch (entry.getKey()) {
			case CARS_COUNT:
				carCount.setValue(entry.getValue());
				break;
			case MANUFACTURERS_COUNT:
				manuCount.setValue(entry.getValue());
				break;
			case AVERAGE_PRICE:
				avgPrice.setValue(entry.getValue());
				break;
			case AVERAGE_DISTANCE:
				avgDist.setValue(entry.getValue());
				break;
			case AVERAGE_AGE:
				avgAge.setValue(entry.getValue());
				break;
			}
		}
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * setPresenter
	 * 
	 * @param carSummaryPresenter2
	 */
	public void setPresenter(CarSummaryPresenter carSummaryPresenter) {
		this.presenter = carSummaryPresenter;
	}
}