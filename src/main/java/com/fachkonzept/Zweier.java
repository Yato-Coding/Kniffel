package main.java.com.fachkonzept;

public class Zweier extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				if (augenzahl == 2) {
					punktzahl += augenzahl;
				}
			}
			istEingetragen = true;
		}
	}
}
