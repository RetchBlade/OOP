package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.Buergeraemter.BuergeraemterControl;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new BuergeraemterControl(primaryStage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
