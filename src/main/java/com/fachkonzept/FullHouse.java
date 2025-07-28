package main.java.com.fachkonzept;

import java.util.Map;
import java.util.HashMap;

public class FullHouse extends Figur {
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

			boolean zwei = false;
			boolean drei = false;

			for (Map.Entry<Integer, Integer> augenzahl : augenzahlen.entrySet()) {
				if (augenzahl.getValue() == 2) {
					zwei = true;
				} else if (augenzahl.getValue() == 3) {
					drei = true;
				}
			}

			if (zwei && drei) {
				punktzahl = 25;
			}
			istEingetragen = true;
		}
	}
}
