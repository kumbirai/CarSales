/**
 * za.co.kumbirai.carsales.gui.search<br>
 * 
 * <p><b>Title:</b> GeneralSearchView<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2013<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 09 Jan 2013 1:00:30 PM
 */
package za.co.kumbirai.carsales.gui.search;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import za.co.kumbirai.carsales.model.CarModel;

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
 * <p><b>Title:</b> GeneralSearchView<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 09 Jan 2013 1:00:30 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class GeneralSearchView extends VBox {
	private GeneralSearchPresenter presenter;
	private ObservableList<CarModel> carEntries;
	private TableView<CarModel> table;

	/**
	 * 
	 */
	public GeneralSearchView() {
		buildView();
	}

	/** Setter for the <code>presenter</code> attribute.
	 * @param GeneralSearchPresenter presenter
	 */
	public void setPresenter(GeneralSearchPresenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 09 Jan 2013
	 * 
	 * buildView
	 * 
	 */
	protected void buildView() {
	}
}
