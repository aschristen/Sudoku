package Sudoku;

import java.util.Random;

  public class GrilleSudoku{
  
      private int [][] grille=null;      
      private int idim=-1;
      private int jdim=-1;
      private int [][] ligneoccupation=null;
  	  private int [][] collognesoccupation=null;
  	  private int [][] subgrilleoccupation=null;

      public GrilleSudoku(int [][] grille_read, int idimr, int jdimr){
          this.idim=idimr;
          this.jdim=jdimr;
          this.grille=new int [this.idim][this.jdim];
                for (int i=0; i<this.grille.length; i++){
                        for (int j=0; j<this.grille[0].length; j++){
                                this.grille[i][j]=grille_read[i][j];
                        }
                }
          this.ligneoccupation=new int[this.idim][this.jdim];
          this.collognesoccupation=new int[this.idim][this.jdim];
          this.subgrilleoccupation=new int[this.idim][this.jdim];     
      }

      public GrilleSudoku(int idim_r, int jdim_r){
                this.idim=idim_r;
                this.jdim=jdim_r;
                this.grille=new int[this.idim][this.jdim];
                this.ligneoccupation=new int[this.idim][this.jdim];
                this.collognesoccupation=new int[this.idim][this.jdim];
                this.subgrilleoccupation=new int[this.idim][this.jdim];
      }
      
      public void InitializeGrid() {
           for (int i=0; i<this.grille.length; i++) {
        	   for (int j=0; j<this.grille[i].length; j++) {
        		   this.grille[i][j]=0;
        	   }   
           }
      }

       public int [][] getGrille(){
               return this.grille;
       }
        
       public int [][] getligneoccupation(){
        	return this.ligneoccupation;
       }
       public int [][] getcollognesoccupation(){
        	return this.collognesoccupation;
       }
        
       public int [][] getsubgrilleoccupation(){
        	return this.subgrilleoccupation;
       }
        
       public int getiDim(){
            return this.idim;
       }
       public int getjDim(){
            return this.jdim;
       }
       public void setGrille(String[] stringtab){
            this.grille=new int [this.idim][this.jdim];
            int i=4;      
            for (int ii=0; ii<this.grille.length; ii++){
            	for (int jj=0; jj<this.grille[ii].length; jj++){
            		this.grille[ii][jj]=Integer.parseInt(stringtab[i]);
            		i++;
            	}
            }
       }       
       public void afficherGrille(){
        	
        	for (int ii=0; ii<this.getGrille().length; ii++){
        		for (int jj=0; jj<this.getGrille()[ii].length; jj++){
        			System.out.print("|" + this.getGrille()[ii][jj]);	
                }
        		System.out.print("|"+"\n");
        	}
       }
       public void afficherGrille_useGUI() {
        	
        	CalcGUI Grilleprint=new CalcGUI();
        	
        	for (int ii=0; ii<this.getGrille().length; ii++){
        		for (int jj=0; jj<this.getGrille()[ii].length; jj++){
        			Grilleprint.afficheValeurint(this.getGrille()[ii][jj],ii+1,jj+1);
        			if(this.getGrille()[ii][jj]==0) {
        				Grilleprint.effaceCase(ii+1,jj+1);
        			}
                }
        	}
       }
       public void gridGenerator() {
    	   this.InitializeGrid();
    	   this.afficherGrille_useGUI();
       }
        
       
       
       public void GenerateFullGrid() {
    	   int[] Numbers= { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    	   this.FullGrid(Numbers);
       }
       
       public void FullGrid(int [] Numbers) {
    	   
       }
       
       public int [] ShuffleArrayNumbers(int [] ArrayNumbers) {

 /* Shuffle Array using Random Class */
    	   
    	   Random rand = new Random();
    	   for (int i = 0; i < ArrayNumbers.length; i++) {
    		   int randomIndexToSwap = rand.nextInt(ArrayNumbers.length);
    		   int tempsave = ArrayNumbers[randomIndexToSwap];
    		   ArrayNumbers[randomIndexToSwap] = ArrayNumbers[i];
    		   ArrayNumbers[i] = tempsave;
    	   }
    	   return ArrayNumbers;
       }
       
       
   	}
 