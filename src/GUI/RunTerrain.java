package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class RunTerrain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new GUIHome();
	}
	
	public static void main(String[] args) {
		//new GUIHome();
		Application.launch(args);
	}

	
	
}
