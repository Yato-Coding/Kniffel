package main.java.com.fachkonzept;

public class Sechser extends Figur{
        public void trageEin(int[] pAugenzahl){
                istEingetragen = true;
		for(int augenzahl : pAugenzahl){
			if(augenzahl == 6){
				punktzahl += augenzahl;
			}
		}
        }
}
