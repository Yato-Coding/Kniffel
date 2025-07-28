package main.java.com.fachkonzept;

public class Vierer extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				if (augenzahl == 4) {
					punktzahl += augenzahl;
				}
			}
			istEingetragen = true;
		}
	}
}
