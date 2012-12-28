/**
 * za.co.kumbirai.carsales.gui.main<br>
 * 
 * <p><b>Title:</b> MainView<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:21:06 PM
 */
package za.co.kumbirai.carsales.gui.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
 * <p><b>Title:</b> MainView<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:21:06 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class MainView extends BorderPane {
	private MainPresenter presenter;
	private BorderPane contentArea;

	/**
	 * 
	 */
	public MainView() {
		buildView();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * setPresenter
	 * 
	 * @param mainPresenter
	 */
	public void setPresenter(MainPresenter mainPresenter) {
		this.presenter = mainPresenter;
	}

	public void setContent(Node content) {
		contentArea.setCenter(content);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * buildView
	 * 
	 */
	protected void buildView() {
		VBox topArea = new VBox(5);
		topArea.getChildren().add(createMenuBar());
		topArea.getStyleClass().add("header");

		Label titleLabel = new Label("My Car Sales");
		titleLabel.getStyleClass().add("title");
		topArea.getChildren().add(titleLabel);

		Label tagLine = new Label("Car Sales System");
		tagLine.getStyleClass().add("tag-line");
		topArea.getChildren().add(tagLine);

		//setTop(topArea);
		setTop(createMenuBar());

		setLeft(createLeftMenu());
		contentArea = new BorderPane();
		contentArea.getStyleClass().add("body");

		setCenter(contentArea);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 21 Dec 2012
	 * 
	 * createMenus
	 * 
	 * @return
	 */
	MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		//menuBar.getMenus().set(0, fileMenu);
		menuBar.getMenus().add(fileMenu);

		MenuItem fileAboutItem = new MenuItem("About");
		MenuItem fileExitItem = new MenuItem("Exit");

		fileMenu.getItems().add(fileAboutItem);
		fileMenu.getItems().add(fileExitItem);

		return menuBar;
	}

	private String selected = "Welcome";

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 21 Dec 2012
	 * 
	 * createLeftMenu
	 * 
	 * @return
	 */
	VBox createLeftMenu() {
		ListView<String> list = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList("Welcome", "Add a Car", "Show all makes and models", "Search on age",
				"Search on Price and Distance traveled");
		VBox left = new VBox(5);
		//left.setMaxWidth(200);
		left.getChildren().add(list);

		list.setItems(data);
		list.getSelectionModel().select(this.selected);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				System.out.printf("old_val = %s, new_val = %s\n", old_val, new_val);
				if ("Welcome".equalsIgnoreCase(new_val)) {
					presenter.showSummary();
				}
				if ("Add a Car".equalsIgnoreCase(new_val)) {
					presenter.showCarDetails(null);
				}
				if ("Show all makes and models".equalsIgnoreCase(new_val)) {
					presenter.showSearchResults();
				}
			}
		});

		return left;
	}
}