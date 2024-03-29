/**
 * za.co.kumbirai.carsales.gui.search<br>
 * 
 * <p><b>Title:</b> CarSearchView<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 20 Dec 2012 3:36:04 PM
 */
package za.co.kumbirai.carsales.gui.search;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import za.co.kumbirai.carsales.entities.Car;
import za.co.kumbirai.carsales.model.CarModel;

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
 * <p><b>Title:</b> CarSearchView<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 20 Dec 2012 3:36:04 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class CarSearchView extends VBox {
	private CarSearchPresenter presenter;
	private ObservableList<CarModel> carEntries;
	private TableView<CarModel> table;

	/**
	 * 
	 */
	public CarSearchView() {
		buildView();
	}

	/** Setter for the <code>presenter</code> attribute.
	 * @param CarSearchPresenter presenter
	 */
	public void setPresenter(CarSearchPresenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * setCars
	 * 
	 * @param value
	 */
	public void setCars(List<Car> searchResults) {
		carEntries = FXCollections.observableArrayList();
		for (Car car : searchResults) {
			carEntries.add(new CarModel(car));
		}
		if (table != null)
			table.setItems(carEntries);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * buildView
	 * 
	 */
	protected void buildView() {
		setSpacing(10);
		HBox menuBar = new HBox(10);

		Button newButton = new Button("New");
		newButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				presenter.newCar();
			}
		});

		menuBar.getChildren().add(newButton);

		getChildren().add(menuBar);

		table = new TableView<CarModel>();

		TableColumn<CarModel, String> manufacturerCol = new TableColumn<CarModel, String>("Manufacturer");
		manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
		manufacturerCol.setPrefWidth(100);
		table.getColumns().add(manufacturerCol);

		TableColumn<CarModel, String> modelCol = new TableColumn<CarModel, String>("Model");
		modelCol.setCellValueFactory(new PropertyValueFactory("model"));
		modelCol.setPrefWidth(145);
		table.getColumns().add(modelCol);

		TableColumn<CarModel, Integer> carYearCol = new TableColumn<CarModel, Integer>("Year");
		carYearCol.setCellValueFactory(new PropertyValueFactory("carYear"));
		carYearCol.setPrefWidth(70);
		table.getColumns().add(carYearCol);

		TableColumn<CarModel, Double> kilometersCol = new TableColumn<CarModel, Double>("Milage");
		kilometersCol.setCellValueFactory(new PropertyValueFactory("kilometers"));
		kilometersCol.setCellFactory(getCustomCellFactory(0));
		kilometersCol.setPrefWidth(90);
		table.getColumns().add(kilometersCol);

		TableColumn<CarModel, Double> priceCol = new TableColumn<CarModel, Double>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory("price"));
		priceCol.setCellFactory(getCustomCellFactory(2));
		priceCol.setPrefWidth(90);
		table.getColumns().add(priceCol);

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				CarModel car = (CarModel) newValue;
				if (car != null && (car.getId() != null && !car.getId().equals(0L))) {
					presenter.carSelected(car.getId());
				}
			}
		});

		BorderPane.setMargin(table, new Insets(10, 10, 10, 10));
		VBox.setVgrow(table, Priority.ALWAYS);
		getChildren().add(table);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * getCustomCellFactory
	 * 
	 * @param color
	 * @return
	 */
	private Callback<TableColumn<CarModel, Double>, TableCell<CarModel, Double>> getCustomCellFactory(final int type) {
		return new Callback<TableColumn<CarModel, Double>, TableCell<CarModel, Double>>() {

			@Override
			public TableCell<CarModel, Double> call(TableColumn<CarModel, Double> param) {
				TableCell<CarModel, Double> cell = new TableCell<CarModel, Double>() {

					@Override
					public void updateItem(final Double item, boolean empty) {
						if (item != null) {
							switch (type) {
							case 0:
								setText(String.format("%,.0f", item));
								break;
							case 1:
								setText(String.format("%,.1f", item));
								break;
							case 2:
								setText(String.format("%,.2f", item));
								break;
							}
						}
					}
				};
				cell.setAlignment(Pos.CENTER_RIGHT);
				return cell;
			}
		};
	}
}