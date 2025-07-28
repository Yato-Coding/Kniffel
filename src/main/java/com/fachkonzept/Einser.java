package main.java.com.fachkonzept;

public class Einser extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			for (int augenzahl : pAugenzahl) {
				if (augenzahl == 1) {
					punktzahl += augenzahl;
				}

			}
			istEingetragen = true;
		}
	}
}
