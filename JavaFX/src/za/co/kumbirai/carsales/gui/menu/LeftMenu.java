/**
 * za.co.kumbirai.carsales.gui.menu<br>
 * 
 * <p><b>Title:</b> LeftMenu<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:34:06 PM
 */
package za.co.kumbirai.carsales.gui.menu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import za.co.kumbirai.carsales.gui.main.MainPresenter;

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
 * <p><b>Title:</b> LeftMenu<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:34:06 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class LeftMenu extends VBox {
	static class ColorRectCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			Rectangle rect = new Rectangle(100, 20);
			if (item != null) {
				rect.setFill(Color.web("blueviolet"));
				setGraphic(rect);
			}
		}
	}

	private final MainPresenter presenter;
	private ListView<String> list = new ListView<String>();
	private ObservableList<String> data = FXCollections.observableArrayList("Welcome", "Add a Car", "Show all makes and models", "Search on age",
			"Search on Price and Distance traveled");
	private String selected = "Welcome";

	/**
	 * 
	 */
	public LeftMenu(MainPresenter presenter) {
		super(5);
		this.presenter = presenter;
		buildView();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * buildView
	 * 
	 */
	protected void buildView() {
		//setMinWidth(150);
		setMaxWidth(200);
		getChildren().add(list);

		list.setItems(data);

		//		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
		//			@Override
		//			public ListCell<String> call(ListView<String> list) {
		//				return new ColorRectCell();
		//			}
		//		});

		list.getSelectionModel().select(this.selected);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				System.out.printf("old_val = %s, new_val = %s\n", old_val, new_val);
			}
		});
	}

	/** Setter for the <code>selected</code> attribute.
	 * @param String selected
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}
}
