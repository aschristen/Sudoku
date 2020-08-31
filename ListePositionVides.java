package Sudoku;

public class ListePositionVides {

	PositionVide premier;
	
	public ListePositionVides(){
		this.premier=null;
	}

	public ListePositionVides(PositionVide p){
		this.premier=p;	
	}
	public PositionVide getPremier(){
		return this.premier;
	
	}
	public void addDebut(int nbposible_chifres, int iposc2, int iposc1){
		PositionVide old_premier=this.premier;
		this.premier=new PositionVide(nbposible_chifres,iposc2,iposc1,old_premier);
	}
	public boolean listeestvide(){
		return this.premier==null;
	}


//insertion in an ordered list
	public void sortListe_insertion(int nbposible_chifres_c, int iposc2_c, int iposc1_c){
	
		if(this.listeestvide()){
			this.premier=new PositionVide(nbposible_chifres_c,iposc2_c,iposc1_c,null);
		}else if(this.getPremier().getValeur_nb_admis()>=nbposible_chifres_c){
			this.premier=new PositionVide(nbposible_chifres_c,iposc2_c,iposc1_c,this.premier);
		}else{
			PositionVide avant=this.getPremier();
			PositionVide apres=this.getPremier().getSuivant();
			while(apres!=null && (apres.getValeur_nb_admis()<nbposible_chifres_c)){
				avant=apres;
				apres=apres.getSuivant();
			}
			avant.setSuivant(new PositionVide(nbposible_chifres_c,iposc2_c,iposc1_c,apres));
		}	
	}
}