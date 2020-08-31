package Sudoku;

import java.util.Scanner;
import java.io.*;

public class GererfichierSudoku {
	
	public static GrilleSudoku lireFishier() throws ErrorSudoku{
		Scanner sc =null;
		String nomFichier;
		int ndimx, ndimy;
		GrilleSudoku grille_x_y=null;
		
		System.out.println("\n");
		System.out.println("Congratulation, you are about to resolve a Sudoku grid ! "+"\n");
		
            sc = new Scanner(System.in);
            boolean correctreponse=false;
            
            System.out.println("You can either read the grid from a file or use a grid generator");
            System.out.println(" In order to read the grid from a file, press f, otherwise press g");
            String reponse=sc.next();
            while(!correctreponse){
            	if(reponse.equals("g")){
            		System.out.println("An unique sudoku grid will be generated");
            		correctreponse=true;
            	}else if(reponse.equals("f")){
            		System.out.println("The sudoku grid you want to resolve will be read from a file ");
            		correctreponse=true;
            	}else{System.out.println("You have to press f for a grid read from a file or g for a generated grid");
            		sc.nextLine();
            		reponse=sc.next();}
            }
            
            if(reponse.equals("f")){
            	FileInputStream fichier;
                int rfichier;
                System.out.println("Please provide the path and the name of the file where the grid is stocked");
                nomFichier=sc.next();
                StringBuilder elements =new StringBuilder();
                try{
                    fichier=new FileInputStream(nomFichier);
                    rfichier =fichier.read();
                    while(rfichier!=-1){
                    	elements.append((char)(rfichier));
                    	rfichier=fichier.read();
                    }
                    fichier.close();
                }catch(FileNotFoundException ex){System.out.println("The file is not found");
                }catch(IOException exc){System.out.println("Input/output error");
                 exc.printStackTrace();
                 }
                String s=(elements.toString().trim());
                s = s.replaceAll("\\s+", " ");
                String [] stringtab=s.split(" ");
                ndimx=Integer.parseInt(stringtab[2]);
                ndimy=Integer.parseInt(stringtab[3]);
                if(stringtab.length !=ndimx*ndimy+4){
                	throw new ErrorSudoku();
                }
            	grille_x_y =new GrilleSudoku(ndimx, ndimy);
            	grille_x_y.setGrille(stringtab);
            	System.out.println("Your Sudoku grid");
            	grille_x_y.afficherGrille();
            }else{
            	ndimx=9;
            	ndimy=9;
            	grille_x_y = new GrilleSudoku(ndimx, ndimy);
            	grille_x_y.gridGenerator();
            }
            
           
            sc.close();
            return grille_x_y;
	}
/*
	public static void ecrireFishier(GrilleSudoku grille_x_y){
		Scanner sc =null;
		int ndimx, ndimy;
		String nomFichierw;
		sc = new Scanner(System.in);
		FileOutputStream fichierw;
		
		System.out.println("Donnez le nom de fichier ou vous voulez sauvegarder la grille resolue");
		nomFichierw=sc.next();
		try{
			fichierw=new FileOutputStream(nomFichierw);
			String a="Sudoku";
			for (int i=0; i<a.length(); i++){
			  fichierw.write(a.charAt(i));
			}
			fichierw.write('\r'); fichierw.write('\n');
			String b="#findsolutiongameboard";
			for (int ii=0; ii<b.length(); ii++){
                fichierw.write(b.charAt(ii));
            }
			fichierw.write('\r'); fichierw.write('\n');
			ndimx=grille_x_y.getiDim();
			ndimy=grille_x_y.getjDim();
			for (int ii=0; ii<Integer.toString(ndimy).length();ii++){
				fichierw.write(Integer.toString(ndimy).charAt(ii));
			}
			String space=" ";
            fichierw.write(space.charAt(0));
			for (int jj=0; jj<Integer.toString(ndimx).length(); jj++){
				fichierw.write(Integer.toString(ndimx).charAt(jj));
			}
			fichierw.write('\r'); fichierw.write('\n');
			
		}catch(FileNotFoundException ex){System.out.println("Le fichier n'etait pas trouvé");
		}catch(IOException exc){System.out.println("Input/output error");
		      exc.printStackTrace();
		}
	}
	*/
}

class ErrorSudoku extends Error{
	public ErrorSudoku (){
		super();
		System.out.println("Error occurred while reading the file");
	}
}