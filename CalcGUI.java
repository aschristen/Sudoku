package Sudoku;
import java.awt.*;
import javax.swing.*;

// ====================================================================
public class CalcGUI{
    JTextField[][] tft = new JTextField[9][9];
    JPanel jpane;
    JFrame fenetre;
    /** Constructor that creates a graphic window with an empty spreadsheet of 9 lines and 9 columns */
    public CalcGUI(){
    	fenetre = new JFrame();
    	fenetre.setTitle("Sudoku"); 
    	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jpane = new JPanel();
    	fenetre.setContentPane(jpane);
    	jpane.setLayout(new GridLayout(11,11));
    	jpane.setPreferredSize(new Dimension(800, 800));
    	jpane.setBackground(new Color(255,246,140));
    	jpane.setBackground(new Color(255,255,255));
    	for (int i=0; i<9; i++){
    		for (int j=0; j<9; j++){  
    			tft[i][j]=new JTextField();
		        /*tft[i][j].setText(" " + i + " " + j);*/
    			tft[i][j].setHorizontalAlignment(JTextField.CENTER); 
    			tft[i][j].setEditable(false);
    			tft[i][j].setBackground(new Color(255,228,225));
    		}
    	}
    	jpane.setForeground(new Color(255,255,0));
    	jpane.add(new Label(" "));
    	for (int i=0; i<9; i++){
    		jpane.add(new MyJLabel("" + (i+1),JLabel.CENTER));
    	}
    	for (int i=0; i<9; i++){
    		jpane.add(new MyJLabel(""+ (i+1),JLabel.CENTER));
    		for (int j=0; j<9; j++){
    			jpane.add(tft[i][j]);
    		}
    	}
    	fenetre.pack();
    	fenetre.setVisible(true);
    }
    /** méthode qui affiche la chaine s sur la case en ligne x et colonne y */
    public void afficheString(String s, int x, int y){
    	tft[x-1][y-1].setText(s);
    }
   /** méthode qui affiche le réel val sur la case en ligne x et colonne y */
    public  void afficheValeur(float val, int x, int y){
    	tft[x-1][y-1].setText(""+val);
    }
    /** méthode qui affiche l'entier val sur la case en ligne x et colonne y */
    public  void afficheValeurint(int val, int x, int y){
    	tft[x-1][y-1].setText(""+val);
    }
   /** méthode qui efface la case en ligne x et colonne y */
    public void effaceCase(int x, int y){
    	tft[x-1][y-1].setText("");   
    }
}
class MyJLabel extends JTextField{
    MyJLabel(String s, int i){
	super(s,i);
	this.setForeground(new Color(255,255,0));
	this.setBackground(new Color(26,140,150));
	this.setHorizontalAlignment(JTextField.CENTER);
	this.setEditable(false);
    }
} 
