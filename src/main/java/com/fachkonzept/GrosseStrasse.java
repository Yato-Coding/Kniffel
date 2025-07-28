package main.java.com.fachkonzept;

public class GrosseStrasse extends Figur {
	public void trageEin(int[] pAugenzahl) {
		if (!istEingetragen) {
			boolean[] vorhanden = new boolean[6];

			for (int i = 0; i < pAugenzahl.length; i++) {
				switch (pAugenzahl[i]) {
					case 1:
						vorhanden[0] = true;
						break;
					case 2:
						vorhanden[1] = true;
						break;
					case 3:
						vorhanden[2] = true;
						break;
					case 4:
						vorhanden[3] = true;
						break;
					case 5:
						vorhanden[4] = true;
						break;
					case 6:
						vorhanden[5] = true;
						break;
				}
			}

			if (vorhanden[0] && vorhanden[1] && vorhanden[2] && vorhanden[3] && vorhanden[4] ||
					vorhanden[1] && vorhanden[2] && vorhanden[3] && vorhanden[4] && vorhanden[5]) {
				punktzahl = 30;
			}

			istEingetragen = true;
		}
	}
}
