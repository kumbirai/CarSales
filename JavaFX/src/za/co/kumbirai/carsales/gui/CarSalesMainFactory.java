/**
 * za.co.kumbirai.carsales.gui<br>
 * 
 * <p><b>Title:</b> CarSalesMainFactory<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:14:59 PM
 */
package za.co.kumbirai.carsales.gui;

import javafx.stage.Stage;
import za.co.kumbirai.carsales.gui.detail.CarDetailPresenter;
import za.co.kumbirai.carsales.gui.detail.CarDetailView;
import za.co.kumbirai.carsales.gui.main.MainPresenter;
import za.co.kumbirai.carsales.gui.main.MainView;
import za.co.kumbirai.carsales.gui.search.CarSearchPresenter;
import za.co.kumbirai.carsales.gui.search.CarSearchView;
import za.co.kumbirai.carsales.gui.search.GeneralSearchPresenter;
import za.co.kumbirai.carsales.gui.search.GeneralSearchView;
import za.co.kumbirai.carsales.gui.summary.CarSummaryPresenter;
import za.co.kumbirai.carsales.gui.summary.CarSummaryView;
import za.co.kumbirai.carsales.service.SimpleCarSalesService;
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
 * <p><b>Title:</b> CarSalesMainFactory<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:14:59 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSalesMainFactory {
	private Stage stage;
	private MainPresenter mainPresenter;
	private CarSummaryPresenter carSummaryPresenter;
	private CarSearchPresenter carSearchPresenter;
	private CarDetailPresenter carDetailPresenter;
	private GeneralSearchPresenter generalSearchPresenter;
	private CarSalesService service;

	/**
	 * @param stage 
	 * 
	 */
	public CarSalesMainFactory(Stage stage) {
		this.stage = stage;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getMainPresenter
	 * 
	 * @return
	 */
	public MainPresenter getMainPresenter() {
		if (mainPresenter == null) {
			MainView view = new MainView();
			view.setStage(stage);
			mainPresenter = new MainPresenter(view);
			mainPresenter.setCarSummaryPresenter(getCarSummaryPresenter());
			mainPresenter.setCarSearchPresenter(getCarSearchPresenter());
			mainPresenter.setCarDetailPresenter(getCarDetailPresenter());
			mainPresenter.setGeneralSearchPresenter(getGeneralSearchPresenter());
		}
		return mainPresenter;
	}

	/** Getter for the <code>carSummaryPresenter</code> attribute.
	 * @return CarSummaryPresenter - value of the attribute <code>carSummaryPresenter</code>.
	 */
	public CarSummaryPresenter getCarSummaryPresenter() {
		if (this.carSummaryPresenter == null) {
			CarSummaryView view = new CarSummaryView();
			carSummaryPresenter = new CarSummaryPresenter(view, getMainPresenter(), getCarSalesService());
		}
		return this.carSummaryPresenter;
	}

	/** Getter for the <code>carSearchPresenter</code> attribute.
	 * @return CarSearchPresenter - value of the attribute <code>carSearchPresenter</code>.
	 */
	public CarSearchPresenter getCarSearchPresenter() {
		if (this.carSearchPresenter == null) {
			CarSearchView view = new CarSearchView();
			carSearchPresenter = new CarSearchPresenter(view, getMainPresenter(), getCarSalesService());
		}
		return this.carSearchPresenter;
	}

	/** Getter for the <code>carDetailPresenter</code> attribute.
	 * @return CarDetailPresenter - value of the attribute <code>carDetailPresenter</code>.
	 */
	public CarDetailPresenter getCarDetailPresenter() {
		if (this.carDetailPresenter == null) {
			CarDetailView view = new CarDetailView();
			carDetailPresenter = new CarDetailPresenter(view, getMainPresenter(), getCarSalesService());
		}
		return this.carDetailPresenter;
	}

	/** Getter for the <code>generalSearchPresenter</code> attribute.
	 * @return GeneralSearchPresenter - value of the attribute <code>generalSearchPresenter</code>.
	 */
	public GeneralSearchPresenter getGeneralSearchPresenter() {
		if (this.generalSearchPresenter == null) {
			GeneralSearchView view = new GeneralSearchView();
			generalSearchPresenter = new GeneralSearchPresenter(view, getMainPresenter(), getCarSalesService());
		}
		return this.generalSearchPresenter;
	}

	/** Getter for the <code>service</code> attribute.
	 * @return CarSalesService - value of the attribute <code>service</code>.
	 */
	public CarSalesService getCarSalesService() {
		if (this.service == null)
			this.service = SimpleCarSalesService.getInstance();
		return this.service;
	}
}
