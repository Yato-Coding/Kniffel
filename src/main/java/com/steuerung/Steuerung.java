package main.java.com.steuerung;

import com.benutzerschnittstelle.Benutzerschnittstelle;
import main.java.com.fachkonzept.Spielblatt;
import main.java.com.fachkonzept.Bestenliste;
import main.java.com.fachkonzept.Endstand;
import main.java.com.fachkonzept.Wuerfel;

public class Steuerung {
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Spielblatt dasSpielblatt;
	private Bestenliste dieBestenliste;
	private Wuerfel[] derWuerfel;

	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle) {
		dieBenutzerschnittstelle = pBenutzerschnittstelle;
		dasSpielblatt = new Spielblatt();
		dieBestenliste = new Bestenliste();
		derWuerfel = new Wuerfel[5];
		derWuerfel[0] = new Wuerfel();
		derWuerfel[1] = new Wuerfel();
		derWuerfel[2] = new Wuerfel();
		derWuerfel[3] = new Wuerfel();
		derWuerfel[4] = new Wuerfel();
		dieBenutzerschnittstelle.zeigeBestenliste(dieBestenliste.liesAlleEndstaende());
		starteNeuesSpiel();
		starteNeueFigur();
	}

	private void aktualisiereBestenliste() {
		String spielername = dieBenutzerschnittstelle.erfrageSpielername();
		int endsumme = dasSpielblatt.ermittleEndsumme();
		dieBestenliste.trageEndstandEin(new Endstand(spielername, endsumme));
		dieBenutzerschnittstelle.zeigeBestenliste(dieBestenliste.liesAlleEndstaende());
	}

	private void beendeSpiel() {
		dieBenutzerschnittstelle.aktiviereEintragen(false);
		dieBenutzerschnittstelle.aktiviereWuerfel(false);
		dieBenutzerschnittstelle.waehleAlleWuerfelAus();
		dieBenutzerschnittstelle.aktiviereWuerfelauswahl(false);
		aktualisiereBestenliste();
	}

	public void geklicktEintragen(int pFigurNr) {
		if (!dasSpielblatt.istEingetragen(pFigurNr)) {
			int[] augenzahlen = new int[5];
			for (int i = 0; i < 5; i++) {
				augenzahlen[i] = derWuerfel[i].liesAugenzahl();
			}

			dasSpielblatt.trageEin(pFigurNr, augenzahlen);
			lassGewinnkarteAnzeigen();
			if (dasSpielblatt.istBeendetSpiel()) {
				beendeSpiel();
			} else {
				starteNeueFigur();
			}
		}
		else{
			dieBenutzerschnittstelle.zeigeNachricht("Diese Figur ist schon eingetragen");
		}
	}

	public void geklicktNeuesSpiel() {
		starteNeuesSpiel();
		starteNeueFigur();
	}

	public void geklicktWuerfeln(boolean[] pWuerfelWerfen) {
		int[] augenzahl = new int[5];
		for (int i = 0; i < 5; i++) {
			if (pWuerfelWerfen[i]) {
				derWuerfel[i].wirf();
			}
			augenzahl[i] = derWuerfel[i].liesAugenzahl();
		}
		Wuerfel.geworfen();
		dieBenutzerschnittstelle.zeigeWuerfel(augenzahl);
		dieBenutzerschnittstelle.aktiviereEintragen(true);
		if (Wuerfel.darfNochmalWuerfelnAktFigur()) {
			dieBenutzerschnittstelle.aktiviereWuerfelauswahl(true);
		} else {
			dieBenutzerschnittstelle.aktiviereWuerfelauswahl(false);
			dieBenutzerschnittstelle.aktiviereWuerfel(false);
		}
	}

	private void lassGewinnkarteAnzeigen() {
		boolean[] eingetragen = new boolean[13];
		for (int i = 0; i < 13; i++) {
			eingetragen[i] = dasSpielblatt.istEingetragen(i);
		}

		int[] punktzahl = new int[18];
		for (int i = 0; i < 13; i++) {
			punktzahl[i] = dasSpielblatt.liesPunktzahlFigur(i);
		}
		punktzahl[13] = dasSpielblatt.ermittlePunkteSummeOben();
		punktzahl[14] = dasSpielblatt.ermittleBonus();
		punktzahl[15] = dasSpielblatt.ermittlePunkteSummeObenMitBonus();
		punktzahl[16] = dasSpielblatt.ermittlePunkteSummeUnten();
		punktzahl[17] = dasSpielblatt.ermittleEndsumme();
		dieBenutzerschnittstelle.zeigeGewinnkarte(eingetragen, punktzahl);

	}

	private void starteNeueFigur() {
		Wuerfel.starteNeueFigur();
		dieBenutzerschnittstelle.aktiviereEintragen(false);
		dieBenutzerschnittstelle.aktiviereWuerfel(true);
		dieBenutzerschnittstelle.waehleAlleWuerfelAus();
		dieBenutzerschnittstelle.aktiviereWuerfelauswahl(false);
	}

	private void starteNeuesSpiel() {
		dasSpielblatt.starteNeuesSpiel();
		dieBenutzerschnittstelle.aktiviereFiguren(true);
		lassGewinnkarteAnzeigen();
	}
}
