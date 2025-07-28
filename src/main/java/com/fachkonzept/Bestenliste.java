package main.java.com.fachkonzept;

import main.java.com.datenspeicherung.db.BestenlisteSpeicher;
import java.lang.Exception;

public class Bestenliste {
	BestenlisteSpeicher derBestenlisteSpeicher;

	public Endstand[] liesAlleEndstaende(){
		try(BestenlisteSpeicher derBestenlisteSpeicher = new BestenlisteSpeicher()){
			return derBestenlisteSpeicher.liesEndstandAusSpeicher();
		} catch (Exception e){
			System.out.println("Fehler beim Lesen der Endstaende: " + System.lineSeparator() + e.getLocalizedMessage());
			return new Endstand[0];
		}
	}

	public void trageEndstandEin(Endstand pEndstand){
		try(BestenlisteSpeicher derBestenlisteSpeicher = new BestenlisteSpeicher()){
                	derBestenlisteSpeicher.schreibeEndstandInSpeicher(pEndstand);
		} catch (Exception e){
			System.out.println("Fehler beim Eintrage der Endstaende: " + System.lineSeparator() + e.getLocalizedMessage());
		}
        }
}
