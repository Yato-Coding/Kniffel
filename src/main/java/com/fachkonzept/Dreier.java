package main.java.com.fachkonzept;

public class Dreier extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				if (augenzahl == 3) {
					punktzahl += augenzahl;
				}
			}
			istEingetragen = true;
		}
	}
}
