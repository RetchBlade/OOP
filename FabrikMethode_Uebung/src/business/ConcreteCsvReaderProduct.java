package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProduct {

	public int leseAnzahlArtikel() throws IOException {
		int anzahlArtikel = 0;
		BufferedReader ein = new BufferedReader(new FileReader("Artikel.csv"));
		anzahlArtikel = Integer.parseInt(ein.readLine());
		ein.close();
		return anzahlArtikel;
	}
	
	public Artikel[] leseArtikel() throws IOException {
		Artikel[] artikel = new Artikel[100];
		BufferedReader ein = new BufferedReader(new FileReader("Artikel.csv"));
		int anzahlArtikel = Integer.parseInt(ein.readLine());
		String[] zeile = null;
		for(int i = 0; i < anzahlArtikel; i++) {
			zeile = ein.readLine().split(";");
			artikel[i] = new Artikel(Integer.parseInt(zeile[0]), zeile[1],Double.parseDouble(zeile[2]));
		}
		ein.close();
		return artikel;
	}
}