/**
 * za.co.kumbirai.carsales.gui<br>
 * 
 * <p><b>Title:</b> CarSalesMain<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:06:33 PM
 */
package za.co.kumbirai.carsales.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
 * <p><b>Title:</b> CarSalesMain<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:06:33 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSalesMain extends Application {

	/**
	 * 
	 */
	public CarSalesMain() {
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		final CarSalesMainFactory factory = new CarSalesMainFactory(stage);
		MainPresenter mainPresenter = factory.getMainPresenter();
		mainPresenter.showSummary();
		Scene scene = new Scene(mainPresenter.getView(), 800, 600);
		scene.getStylesheets().addAll(CarSalesMain.class.getResource("styles.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("My Car Sales");
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				System.out.println("Stage is closing");
				CarSalesService service = factory.getCarSalesService();
				service.saveCars();
			}
		});
		stage.show();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}