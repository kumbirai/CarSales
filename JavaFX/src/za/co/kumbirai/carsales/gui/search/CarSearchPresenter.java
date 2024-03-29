/**
 * za.co.kumbirai.carsales.gui.search<br>
 * 
 * <p><b>Title:</b> CarSearchPresenter<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 20 Dec 2012 3:28:37 PM
 */
package za.co.kumbirai.carsales.gui.search;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import za.co.kumbirai.carsales.entities.Car;
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
 * <p><b>Title:</b> CarSearchPresenter<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 20 Dec 2012 3:28:37 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSearchPresenter {
	private MainPresenter mainPresenter;
	private CarSearchView view;
	private CarSalesService service;

	/**
	 * 
	 */
	public CarSearchPresenter(CarSearchView view, MainPresenter mainPresenter, CarSalesService service) {
		this.view = view;
		this.mainPresenter = mainPresenter;
		this.service = service;
		this.view.setPresenter(this);
	}

	/** Getter for the <code>view</code> attribute.
	 * @return CarSearchView - value of the attribute <code>view</code>.
	 */
	public CarSearchView getView() {
		return this.view;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * search
	 * 
	 */
	public void search() {
		final Task<List<Car>> searchTask = new Task<List<Car>>() {
			protected List<Car> call() throws Exception {
				return service.getCarList();
			}
		};

		searchTask.stateProperty().addListener(new ChangeListener<Worker.State>() {
			public void changed(ObservableValue<? extends Worker.State> source, Worker.State oldState, Worker.State newState) {
				if (newState.equals(Worker.State.SUCCEEDED)) {
					view.setCars(searchTask.getValue());
				}
			}
		});

		new Thread(searchTask).start();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * newCar
	 * 
	 */
	public void newCar() {
		mainPresenter.showCarDetails(null);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * personSelected
	 * 
	 * @param id
	 */
	public void carSelected(Long id) {
		mainPresenter.showCarDetails(id);
	}
}