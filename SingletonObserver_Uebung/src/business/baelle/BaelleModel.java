package business.baelle;

import java.io.*;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;

public class BaelleModel implements Observable{
 		
	private Ball[] baelle = new Ball[100];
	private int anzahlBaelle;
	private static BaelleModel baelleModel;
	private Vector<Observer> observers = new Vector<Observer>();
	
	public int getAnzahlBaelle() {
		return anzahlBaelle;
	}

	public void setAnzahlBaelle(int anzahlBaelle) {
		this.anzahlBaelle = anzahlBaelle;
	}
	
	public Ball[] holeBaelle() {
		Ball[] result = new Ball[this.getAnzahlBaelle()];
		for(int i = 0; i < result.length; i++) {
			result[i] = this.baelle[i];
		}
		return result;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		Ball ball = null;
		int i = 0;
		while (ball == null && i < this.getAnzahlBaelle()) {
			if(Integer.parseInt(einkaufsdatum) == this.holeBaelle()[i].getEinkaufsdatum()){
				ball = this.holeBaelle()[i];
			}
			i++;
		}
		return ball;
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	   	for(int i = 0; i < this.anzahlBaelle; i++) {
	   	 	this.baelle[i] = null;
	   	}
	   	this.anzahlBaelle = Integer.parseInt(ein.readLine());
	   	String[] zeile;
	   	for(int i = 0; i < this.getAnzahlBaelle(); i++) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle[i] = new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5]));
	   	}
	    ein.close();
	    // setChanged();
	    notifyObservers();
 	}
	
	public static BaelleModel getInstance() {
		if(baelleModel == null) {
		baelleModel = new BaelleModel();
		}
		return baelleModel;
		}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.observers.size(); i++){
			this.observers.elementAt(i).update();
			}

	}

}