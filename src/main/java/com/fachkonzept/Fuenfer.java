package main.java.com.fachkonzept;

public class Fuenfer extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				if (augenzahl == 5) {
					punktzahl += augenzahl;
				}
			}
			istEingetragen = true;
		}
	}
}
