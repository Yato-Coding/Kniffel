package main.java.com.fachkonzept;

public class Wuerfel {
	private static int anzahlVersucheAktFigur = 0;
	private int augenzahl;

	public static Boolean darfNochmalWuerfelnAktFigur() {
		return anzahlVersucheAktFigur < 3;
	}

	public static void geworfen() {
		anzahlVersucheAktFigur++;
	}

	public int liesAugenzahl() {
		return augenzahl;
	}

	public static void starteNeueFigur() {
		anzahlVersucheAktFigur = 0;
	}

	public void wirf() {
		augenzahl = (int) ((Math.random() * 6) + 1);
	}
}
