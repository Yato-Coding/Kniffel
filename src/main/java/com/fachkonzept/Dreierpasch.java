package main.java.com.fachkonzept;

import java.util.Map;
import java.util.HashMap;

public class Dreierpasch extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			Map<Integer, Integer> augenzahlen = new HashMap<>();
			int summe = 0;
			for (int zahl : pAugenzahl) {
				if (augenzahlen.containsKey(zahl)) {
					augenzahlen.put(zahl, augenzahlen.get(zahl) + 1);
				} else {
					augenzahlen.put(zahl, 1);
				}
				summe += zahl;
			}

			for (Map.Entry<Integer, Integer> augenzahl : augenzahlen.entrySet()) {
				if (augenzahl.getValue() >= 3) {
					punktzahl = summe;
				}
			}
			istEingetragen = true;
		}
	}
}
