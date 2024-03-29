/**
 * za.co.kumbirai.carsales.gui.summary<br>
 * 
 * <p><b>Title:</b> CarSummaryPresenter<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 20 Dec 2012 12:15:52 PM
 */
package za.co.kumbirai.carsales.gui.summary;

import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import za.co.kumbirai.carsales.StatisticType;
import za.co.kumbirai.carsales.gui.main.MainPresenter;
import za.co.kumbirai.carsales.service.interfaces.CarSalesService;

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
 * <p><b>Title:</b> CarSummaryPresenter<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 20 Dec 2012 12:15:52 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSummaryPresenter {
	private MainPresenter mainPresenter;
	private CarSummaryView view;
	private CarSalesService service;

	/**
	 * @param carSalesService 
	 * @param mainPresenter 
	 * @param view 
	 * 
	 */
	public CarSummaryPresenter(CarSummaryView view, MainPresenter mainPresenter, CarSalesService carSalesService) {
		this.view = view;
		this.mainPresenter = mainPresenter;
		this.service = carSalesService;
		this.view.setPresenter(this);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * search
	 * 
	 */
	public void search() {
		final Task<Map<StatisticType, Double>> searchTask = new Task<Map<StatisticType, Double>>() {
			protected Map<StatisticType, Double> call() throws Exception {
				return service.getStatisticMap();
			}
		};

		searchTask.stateProperty().addListener(new ChangeListener<Worker.State>() {
			public void changed(ObservableValue<? extends Worker.State> source, Worker.State oldState, Worker.State newState) {
				if (newState.equals(Worker.State.SUCCEEDED)) {
					view.setStats(searchTask.getValue());
				}
			}
		});

		new Thread(searchTask).start();
	}

	/** Getter for the <code>view</code> attribute.
	 * @return CarSummaryView - value of the attribute <code>view</code>.
	 */
	public CarSummaryView getView() {
		return this.view;
	}
}