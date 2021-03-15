package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.RestaurantManager;

public class Main extends Application {
	private RestaurantManager restaurantManager;
	private RestaurantManagerGUI restaurantManagerGUI;
	
	public Main(){
		restaurantManager = new RestaurantManager();
		restaurantManagerGUI = new RestaurantManagerGUI(restaurantManager);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(restaurantManagerGUI);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("La Casa Dorada");
		primaryStage.show();
		restaurantManagerGUI.showScreenLogIn();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}