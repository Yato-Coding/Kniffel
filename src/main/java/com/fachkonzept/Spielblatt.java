package main.java.com.fachkonzept;

import main.java.com.fachkonzept.Figur;

public class Spielblatt{
	private Figur[] dieFigur = new Figur[13];

        public Spielblatt(){
		starteNeuesSpiel();
        }

	public int ermittleBonus(){
		if(ermittlePunkteSummeOben() >= 63){
			return 35;
		}
		return 0;
	}

	public int ermittleEndsumme(){
		int endsumme = 0;
		endsumme += ermittlePunkteSummeObenMitBonus();
		endsumme += ermittlePunkteSummeUnten();
		return endsumme;
	}

	public int ermittlePunkteSummeOben(){
		int punkteSummeOben = 0;
		for(int i = 0; i < 6; i++){
			punkteSummeOben += dieFigur[i].liesPunktZahl();
		}
		return punkteSummeOben;
	}

	public int ermittlePunkteSummeObenMitBonus(){
		return ermittlePunkteSummeOben() + ermittleBonus();
	}

	public int ermittlePunkteSummeUnten(){
		int punkteSummeUnten = 0;
		for(int i = 6; i < 13; i++){
			punkteSummeUnten += dieFigur[i].liesPunktZahl();
		}
		return punkteSummeUnten;
	}

	public boolean istBeendetSpiel(){
		for(Figur f : dieFigur){
			if(!f.istEingetragen){
				return false;
			}
		}
		return true;
	}

	public boolean istEingetragen(int pFigur){
		return dieFigur[pFigur].istEingetragen();
	}

	public int liesPunktzahlFigur(int pFigur){
		return dieFigur[pFigur].liesPunktZahl();
	}

	public void starteNeuesSpiel(){
		dieFigur[0] = new Einser();
                dieFigur[1] = new Zweier();
                dieFigur[2] = new Dreier();
                dieFigur[3] = new Vierer();
                dieFigur[4] = new Fuenfer();
                dieFigur[5] = new Sechser();
                dieFigur[6] = new Dreierpasch();
                dieFigur[7] = new Viererpasch();
                dieFigur[8] = new FullHouse();
                dieFigur[9] = new KleineStrasse();
                dieFigur[10] = new GrosseStrasse();
                dieFigur[11] = new Kniffel();
                dieFigur[12] = new Chance();
	}

	public void trageEin(int pFigurNr, int[] pAugenzahl){
		dieFigur[pFigurNr].trageEin(pAugenzahl);
	}


}
