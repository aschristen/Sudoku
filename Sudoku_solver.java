package Sudoku;

public class Sudoku_solver  {
	
	
	public static void resoudreSudoku(GrilleSudoku grille_current){
		resoudRecursive(grille_current);
	}
	
	public static boolean isVide (int ipos, int jpos, int [][] grille_rec){
		boolean casevide=false;
		if(grille_rec[ipos][jpos]==0){
			casevide=true;
		}
		return casevide;
	}
	
	public static ListePositionVides liste_p (GrilleSudoku grille_current){
		ListePositionVides ListePos=new ListePositionVides();
		int nbpossib_at_posvide=0;
		for (int i=0; i < grille_current.getiDim(); i++){
	        for (int j=0; j < grille_current.getjDim(); j++){
	        	if(Sudoku_solver.isVide(i,j,grille_current.getGrille())){
	        		nbpossib_at_posvide=nb_possib_chiff_case(grille_current,i,j);
	        		if(ListePos.listeestvide()){
	        			ListePos.premier=new PositionVide(nbpossib_at_posvide,j,i,null);
	        		}else{
	        			ListePos.addDebut(nbpossib_at_posvide, j, i);
	        		}
	        	}	
	        }
		}
		return ListePos;
	}
	public static ListePositionVides trier_insertion(ListePositionVides L){
			ListePositionVides L2 =new ListePositionVides();
			PositionVide ref=L.getPremier();
			while(ref!=null){
				L2.sortListe_insertion(ref.getValeur_nb_admis(),ref.getValeur_jcord(),ref.getValeur_icord());
				ref=ref.getSuivant();	
			}
			return L2;
	}
	
	
	public static int nb_possib_chiff_case(GrilleSudoku grille_current, int icase, int jcase){
		int nb_nombres_admissible=0;
		for (int iposn=0; iposn<9; iposn++){
			if((grille_current.getligneoccupation()[icase][iposn]==0)&& (grille_current.getcollognesoccupation()[jcase][iposn]==0)&&(grille_current.getsubgrilleoccupation()[3*(int)(icase/3)+(int)(jcase/3)][iposn]==0))
			{
				nb_nombres_admissible++;
			}
		}
		return nb_nombres_admissible;
	}
	
	public static boolean resoudRecursive (GrilleSudoku grille_current_copy){
			
	    int igdim=grille_current_copy.getiDim();
	    int jgdim=grille_current_copy.getjDim();
	    
		for (int i=0; i<igdim; i++){
			for (int j=0; j<jgdim; j++){
				grille_current_copy.getligneoccupation()[i][j]=0;
				grille_current_copy.getcollognesoccupation()[i][j]=0;
				grille_current_copy.getsubgrilleoccupation()[i][j]=0;
			}
		}
		
		/*
		 *For the values that are present on line i, record 1 
		 *For example : if the value 7 is present on line i, then 
		 *ligneoccupation[i][7-1]=1; The same rule is adopted for the columns and the sub-grids.  
		 */
		
		for (int i=0; i<igdim; i++){
			for (int j=0; j<jgdim; j++){
				if(grille_current_copy.getGrille()[i][j]!=0){
					int deuxindex=grille_current_copy.getGrille()[i][j]-1;
					grille_current_copy.getligneoccupation()[i][deuxindex]=1;
					grille_current_copy.getcollognesoccupation()[j][deuxindex]=1;
					grille_current_copy.getsubgrilleoccupation()[3*(int)(i/3)+(int)(j/3)][deuxindex]=1;
				}
			}
		}
		
		ListePositionVides positions_empty_parcourir=trier_insertion(liste_p(grille_current_copy));
		if (check_if_resolved(grille_current_copy,positions_empty_parcourir)){
			return true;
		}
		return false;
    }
	
	public static boolean check_if_resolved(GrilleSudoku grille, ListePositionVides positions_empty){
		
		if(positions_empty.listeestvide()){
	      return true;
		}
		PositionVide current=positions_empty.getPremier();
		return check_position(grille,current);
	}
	
	public static boolean check_position(GrilleSudoku grille_resoud_c, PositionVide position){
		
		if(position==null){
			return true;
		}
		int icord_c=position.getValeur_icord();
		int jcord_c=position.getValeur_jcord();
	
		for (int inum_poss=0; inum_poss<9; inum_poss++){
			 
			if((grille_resoud_c.getligneoccupation()[icord_c][inum_poss]==0)
				&&(grille_resoud_c.getcollognesoccupation()[jcord_c][inum_poss]==0)
				&&(grille_resoud_c.getsubgrilleoccupation()[3*(int)(icord_c/3)+(int)(jcord_c/3)][inum_poss]==0))
			{
				//grille_resoud_c.getGrille()[icord_c][jcord_c]=inum_poss+1;
				
				/*update ligneoccupation, collognesoccupation, getsubgrilleoccupation 
					in order to take into consideration that inum_poss is included in the grid 
				*/
				
				grille_resoud_c.getligneoccupation()[icord_c][inum_poss]=1;
				grille_resoud_c.getcollognesoccupation()[jcord_c][inum_poss]=1;
				grille_resoud_c.getsubgrilleoccupation()[3*(int)(icord_c/3)+(int)(jcord_c/3)][inum_poss]=1;
				
				if(check_position(grille_resoud_c, position.getSuivant())){
					grille_resoud_c.getGrille()[icord_c][jcord_c]=inum_poss+1;
					return true;
				}else{
					grille_resoud_c.getligneoccupation()[icord_c][inum_poss]=0;
					grille_resoud_c.getcollognesoccupation()[jcord_c][inum_poss]=0;
					grille_resoud_c.getsubgrilleoccupation()[3*(int)(icord_c/3)+(int)(jcord_c/3)][inum_poss]=0;
				}
			}
			
	    }
		return false;	
	}	
}