package main.java.com.fachkonzept;

import java.util.Map;
import java.util.HashMap;

public class Kniffel extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			Map<Integer, Integer> augenzahlen = new HashMap<>();

			for (int zahl : pAugenzahl) {
				if (augenzahlen.containsKey(zahl)) {
					augenzahlen.put(zahl, augenzahlen.get(zahl) + 1);
				} else {
					augenzahlen.put(zahl, 1);
				}
			}

			for (Map.Entry<Integer, Integer> augenzahl : augenzahlen.entrySet()) {
				if (augenzahl.getValue() == 5) {
					punktzahl = 50;
				}
			}
			istEingetragen = true;
		}
	}
}
