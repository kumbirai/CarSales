/**
 * za.co.kumbirai.carsales.gui.detail<br>
 * 
 * <p><b>Title:</b> CarDetailPresenter<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 24 Dec 2012 11:51:43 AM
 */
package za.co.kumbirai.carsales.gui.detail;

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
 * <p><b>Title:</b> CarDetailPresenter<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 24 Dec 2012 11:51:43 AM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarDetailPresenter {
	private MainPresenter mainPresenter;
	private CarDetailView view;
	private CarSalesService service;

	/**
	 * 
	 */
	public CarDetailPresenter(CarDetailView view, MainPresenter mainPresenter, CarSalesService service) {
		this.view = view;
		this.mainPresenter = mainPresenter;
		this.service = service;
		this.view.setPresenter(this);
	}

	/** Getter for the <code>view</code> attribute.
	 * @return CarDetailView - value of the attribute <code>view</code>.
	 */
	public CarDetailView getView() {
		return this.view;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 27 Dec 2012
	 * 
	 * show
	 * 
	 * @param carId
	 */
	public void show(final Long carId) {
		final Task<Car> searchTask = new Task<Car>() {
			protected Car call() throws Exception {
				return service.getCar(carId);
			}
		};

		searchTask.stateProperty().addListener(new ChangeListener<Worker.State>() {
			public void changed(ObservableValue<? extends Worker.State> source, Worker.State oldState, Worker.State newState) {
				if (newState.equals(Worker.State.SUCCEEDED)) {
					view.setCar(searchTask.getValue());
				}
			}
		});

		new Thread(searchTask).start();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * save
	 * @param myCar
	 * 
	 */
	public void save(final Car car) {
		final Task<Car> saveTask = new Task<Car>() {
			protected Car call() throws Exception {
				return service.saveCar(car);
			}
		};

		saveTask.stateProperty().addListener(new ChangeListener<Worker.State>() {
			public void changed(ObservableValue<? extends Worker.State> source, Worker.State oldState, Worker.State newState) {
				if (newState.equals(Worker.State.SUCCEEDED)) {
					//view.setCar(saveTask.getValue());
					mainPresenter.showSearchResults();
				}
			}
		});

		new Thread(saveTask).start();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * delete
	 * 
	 */
	public void delete() {
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * cancel
	 * 
	 */
	public void cancel() {
		mainPresenter.showSearchResults();
	}
}