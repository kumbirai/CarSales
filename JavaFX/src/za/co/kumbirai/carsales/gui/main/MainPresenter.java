/**
 * za.co.kumbirai.carsales.gui.main<br>
 * 
 * <p><b>Title:</b> MainPresenter<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:16:16 PM
 */
package za.co.kumbirai.carsales.gui.main;

import za.co.kumbirai.carsales.gui.detail.CarDetailPresenter;
import za.co.kumbirai.carsales.gui.search.CarSearchPresenter;
import za.co.kumbirai.carsales.gui.summary.CarSummaryPresenter;

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
 * <p><b>Title:</b> MainPresenter<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:16:16 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class MainPresenter {
	private MainView view;
	private CarSummaryPresenter carSummaryPresenter;
	private CarSearchPresenter carSearchPresenter;
	private CarDetailPresenter carDetailPresenter;

	/**
	 * @param view 
	 * 
	 */
	public MainPresenter(MainView view) {
		this.view = view;
		this.view.setPresenter(this);
	}

	/** Getter for the <code>view</code> attribute.
	 * @return MainView - value of the attribute <code>view</code>.
	 */
	public MainView getView() {
		return this.view;
	}

	/** Setter for the <code>carSummaryPresenter</code> attribute.
	 * @param CarSummaryPresenter carSummaryPresenter
	 */
	public void setCarSummaryPresenter(CarSummaryPresenter carSummaryPresenter) {
		this.carSummaryPresenter = carSummaryPresenter;
	}

	/** Setter for the <code>carSearchPresenter</code> attribute.
	 * @param CarSearchPresenter carSearchPresenter
	 */
	public void setCarSearchPresenter(CarSearchPresenter carSearchPresenter) {
		this.carSearchPresenter = carSearchPresenter;
	}

	/** Setter for the <code>carDetailPresenter</code> attribute.
	 * @param CarDetailPresenter carDetailPresenter
	 */
	public void setCarDetailPresenter(CarDetailPresenter carDetailPresenter) {
		this.carDetailPresenter = carDetailPresenter;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * showSummary
	 * 
	 */
	public void showSummary() {
		carSummaryPresenter.search();
		view.setContent(carSummaryPresenter.getView());
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 27 Dec 2012
	 * 
	 * showSearchResults
	 * 
	 */
	public void showSearchResults() {
		carSearchPresenter.search();
		view.setContent(carSearchPresenter.getView());
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 27 Dec 2012
	 * 
	 * showCarDetails
	 * 
	 * @param carId
	 */
	public void showCarDetails(Long carId) {
		System.out.printf("MainPresenter#showCarDetails called with carId = %s\n", carId);
		carDetailPresenter.show(carId);
		view.setContent(carDetailPresenter.getView());
	}
}