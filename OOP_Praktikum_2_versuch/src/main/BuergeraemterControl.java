package main;

import java.io.IOException;
import business.*;
import javafx.application.Application;
import javafx.stage.Stage;
import gui.*;

public class BuergeraemterControl extends Application{
	
	private BuergeraemterModel buergeraemterModel;
	private BuergeraemterView buergeraemterView;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.buergeraemterModel = new BuergeraemterModel();
		this.buergeraemterView = new BuergeraemterView(primaryStage, this, buergeraemterModel);
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void schreibeBuergeraemterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				this.buergeraemterView.zeigeInformationsfensterAn("Die Buegeraemte wurden gespeichert");
			} else {
				this.buergeraemterModel.schreibeBuergeraemterInTxtDatei();
				this.buergeraemterView.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		} 
	}
	
}

