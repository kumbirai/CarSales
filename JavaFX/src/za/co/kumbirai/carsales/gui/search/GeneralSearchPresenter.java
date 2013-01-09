/**
 * za.co.kumbirai.carsales.gui.search<br>
 * 
 * <p><b>Title:</b> GeneralSearchPresenter<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2013<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 09 Jan 2013 1:01:06 PM
 */
package za.co.kumbirai.carsales.gui.search;

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
 * Copyright (c) 2013<br>
 * 
 * <p><b>Title:</b> GeneralSearchPresenter<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 09 Jan 2013 1:01:06 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class GeneralSearchPresenter {
	private MainPresenter mainPresenter;
	private GeneralSearchView view;
	private CarSalesService service;

	/**
	 * 
	 */
	public GeneralSearchPresenter(GeneralSearchView view, MainPresenter mainPresenter, CarSalesService service) {
		this.view = view;
		this.mainPresenter = mainPresenter;
		this.service = service;
		this.view.setPresenter(this);
	}

	/** Getter for the <code>view</code> attribute.
	 * @return GeneralSearchView - value of the attribute <code>view</code>.
	 */
	public GeneralSearchView getView() {
		return this.view;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 09 Jan 2013
	 * 
	 * show
	 * 
	 */
	public void show() {
	}
}