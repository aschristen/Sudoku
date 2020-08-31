package Sudoku;

public class PositionVide {
	
	private int nb_nombres_admissible=0;
	private int icordcase=-1, jcordcase=-1;
	PositionVide suivant=null;

	PositionVide(){
		this.nb_nombres_admissible=0;
		this.jcordcase=-1;
		this.icordcase=-1;
		this.suivant=null;		
	}

	PositionVide(int nb, int jcord, int icord, PositionVide p){
		this.nb_nombres_admissible=nb;
		this.jcordcase=jcord;
		this.icordcase=icord;
		this.suivant=p;		
	}

	public PositionVide getSuivant(){
		return this.suivant;
	}

	public int getValeur_nb_admis(){
		return this.nb_nombres_admissible;
	}
	public int getValeur_jcord(){
		return this.jcordcase;
	}
	public int getValeur_icord(){
		return this.icordcase;
	}

	public void setValeur(int nb, int jcord, int icord){
		this.nb_nombres_admissible=nb;
		this.jcordcase=jcord;
		this.icordcase=icord;
	}

	public void setSuivant(PositionVide p){
		this.suivant=p;
	}
}