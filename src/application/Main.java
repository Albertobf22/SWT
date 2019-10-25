package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private ObservableList<Productos> productData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public Main() {
        // Add some sample data
    	productData.add(new Productos("Nike Hoodie", 50, 70));
    	productData.add(new Productos("StreetSwear", 100, 50));
        productData.add(new Productos("Vintage Shirt", 25,30));
        productData.add(new Productos("Street Shirt", 100, 20));
        productData.add(new Productos("Joggins", 100, 40));
        productData.add(new Productos("Cargo", 50, 25));
        productData.add(new Productos("Nike Air Force 1", 45, 70));
        productData.add(new Productos("Complement", 83, 25));
        productData.add(new Productos("Nike zoom air 270", 250, 100));
    }
  
     @return
     
    public ObservableList<Productos> getProductData() {
        return productData;
    }
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Sample.fxml"));
			HBox root = (HBox)loader.load();
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SampleController controller = loader.getController();
			controller.setMainApp(this);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
