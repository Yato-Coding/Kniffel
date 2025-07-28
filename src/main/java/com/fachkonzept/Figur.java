package main.java.com.fachkonzept;

public abstract class Figur{
	protected Boolean istEingetragen;
	protected int punktzahl;

	public Figur(){
		istEingetragen = false;
                punktzahl = 0;
	}

	public Boolean istEingetragen(){
		return istEingetragen;
	}

	public int liesPunktZahl(){
		return punktzahl;
	}

	public abstract void trageEin(int[] pAugenzahl);
}
