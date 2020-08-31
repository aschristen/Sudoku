package Sudoku;
public class Sudoku{
	

		public static void main(String[] args) {

			GrilleSudoku grille_s=null;

			// Read the Sudoku grid from a file or generate it 
			try{
			   grille_s=GererfichierSudoku.lireFishier();
			   System.out.println("\n");
			   System.out.println("Print out/show the grid read off the file "+"\n");
               grille_s.afficherGrille();
               grille_s.afficherGrille_useGUI();
			}catch(ErrorSudoku e){
				System.out.println(e);
			    e.printStackTrace();
			}
			    Sudoku_solver.resoudreSudoku(grille_s);
			    System.out.println("\n");
			    System.out.println("Resolving the grid "+"\n");
			    System.out.println("Printing out the resolved grid "+"\n");
                grille_s.afficherGrille();
                grille_s.afficherGrille_useGUI();
                /*
                for (int ii=0; ii<grille_s.getiDim(); ii++){
                	for (int jj=0; jj<grille_s.getjDim(); jj++){
                		Grilleprint.afficheValeur(grille_s.getGrille()[ii][jj], ii, jj);
                	}
                }
                */
                /*
			try{
			   System.out.println("La grille resolue serait sauvegarde dans un fichier");
	           GererfichierSudoku.ecrireFishier(grille_s);
			}catch(ErrorSudoku e){
				System.out.println(e);
			    e.printStackTrace();
			}
			*/
		}
}
