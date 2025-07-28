package main.java.com.fachkonzept;

public class Endstand {
	private String name;
	private int punkte;

	public Endstand(String pName, int pPunkte) {
		name = pName;
		punkte = pPunkte;
	}

	public String liesName() {
		return name;
	}

	public int liesPunkte() {
		return punkte;
	}
}
