package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import application.Main;
import application.Productos;

public class SampleController2 {

	private Main main;

	@FXML
	private TableView<Productos> productoTable;
	@FXML
	private TableColumn<Productos, String> descripcionColumn;
	@FXML
	private TableColumn<Productos, Integer> stockColumn;

	@FXML
	private Label txtDescripcion;

	@FXML
	private Label txtPrecio;

	@FXML
	private Label txtStock;

	@FXML
	private Label txtFecha;

	public SampleController2() {
	}
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
		stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
		showProductosDetails(null);
		
		productoTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showProductosDetails(newValue));

	}

	public void setMainApp(Main main) {
		this.main = main;

		// Add observable list data to the table
		productoTable.setItems(this.main.getProductData());
	}

	private void showProductosDetails(Productos productos) {
		if (productos != null) {
			// Fill the labels with info from the person object.
			txtDescripcion.setText(productos.getDescripcion());
			txtStock.setText(Integer.toString(productos.getStock()));
			txtPrecio.setText(Integer.toString(productos.getprecio()));
			txtFecha.setText(DateUtil.format(productos.getfecha()));

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			// Person is null, remove all the text.
			txtDescripcion.setText("");
			txtStock.setText("");
			txtPrecio.setText("");
			txtFecha.setText("");
		}
	}

}