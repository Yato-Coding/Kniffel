package main.java.com.fachkonzept;

public class Chance extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				punktzahl += augenzahl;
			}
			istEingetragen = true;
		}
	}
}
