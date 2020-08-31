package Sudoku;
class UseCalcGUI{

    public static void main(String[] args){
    	CalcGUI fenetre = new CalcGUI();
    	fenetre.afficheString("Sudoku",2,3);
    	fenetre.afficheValeur(145,4,3);
    	fenetre.effaceCase(3,7);
    }
}
