import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainExo3 {
	
	 public static void main(String[] args) {  
		 Scanner lecteur = new Scanner(System.in);  
		 // Lecture du nom de fichier 40    
		 System.out.println("Donner le nom de fichier :");
		 String nom = lecteur.next(); 
		 // Affichage du contenu du fichier 44    
		 try {
			Exo3AfficherFichier.afficherFichier(nom);
		} catch (FileNotFoundException e) {
			
			System.out.println("Le fichier n'existe pas!");
			System.out.println( e.getStackTrace() );
		}catch (Exception e) {
			
			System.out.println( e.getMessage() );
		}
		 
	 
	 }
}
