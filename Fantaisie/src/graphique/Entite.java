package graphique;

import java.util.ArrayList;

import jeuRole.Arc;
import jeuRole.Arme;
import jeuRole.Epee;
import jeuRole.EtreVivant;

public class Entite {

	ArrayList<EtreVivant> etreVivants = new ArrayList<EtreVivant>();
	ArrayList<Arme> armes = new ArrayList<Arme>();
	
	public void ajouterEtreVivant(EtreVivant etreVivant) {
		this.etreVivants.add(etreVivant);
		System.out.println("L'être vivant "+etreVivant.getNom()+" a été ajouté");
	}
	
	public ArrayList<EtreVivant> getEtreVivants() {
		return etreVivants;
	}
	
	public EtreVivant getEtreVivant (int index){
		return this.etreVivants.get(index);
	}
	
	public void ajouterArme(Arme arme) {
		this.armes.add(arme);
		if (arme instanceof Epee){
			Epee epee = (Epee) arme;
			System.out.println("L'épée "+epee.getNom()+" a été ajoutés");
		}
		else if (arme instanceof Arc){
			Arc arc = (Arc) arme;
			System.out.println("L'arc et les "+arc.getNbrFleche() + " flèches ont été ajouté");
			
		}
		else System.out.println("Le lance pierre a été ajouté");
	}
	
//	public void supprimerArme(Arme arme){
//		this.armes.remove(arme);
//	}
	
	public ArrayList<Arme> getArmes() {
		return armes;
	}
	
	public void supprimerEtreVivant(EtreVivant etreVivant){
		this.etreVivants.remove(etreVivant);
	}
	
}

