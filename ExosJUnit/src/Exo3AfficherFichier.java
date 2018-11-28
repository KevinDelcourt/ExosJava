import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; 

class Exo3AfficherFichier  {  
	
	public static void afficherFichier(String nomDeFichier) throws Exception { 
		   // Ouverture du fichier 
		 FileInputStream file = null; 
		 file = new FileInputStream(nomDeFichier); 
		 
		 // Lecture et affichage des données 
		 Exo3AfficherFichier.afficherFichier(file); 
		 // Fermeture du fichier
		 file.close();
		 }
	
	private static void afficherFichier(FileInputStream file) throws Exception {
		int b ;
		while ((b = file.read()) != -1)  {   
			System.out.print((char)b); 
		} 
	}
		 
}