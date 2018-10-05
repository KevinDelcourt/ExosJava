package graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import jeuRole.EntiteLivre;
import livre.Fichier;

public class PanHistoire extends Panel {

	private static final long serialVersionUID = 1L;

	Box boxMiseEnPage = Box.createVerticalBox();
	Box boxTexteTitre = Box.createVerticalBox();
	Box boxLivre = Box.createVerticalBox();

	JTextArea aeraMonHistoire = new JTextArea(23, 50);
	String texte;
	
	public PanHistoire() {
		EntiteLivre.setLivre(new Fichier());
	}

	public void initialisation() {
		// Définition de la couleur de fond
		this.setBackground(Color.GREEN);
		// créer une bataille
		JLabel texteTitre = new JLabel("Votre histoire");
		Font police = new Font("Old English Text MT", Font.BOLD, 20);
		texteTitre.setFont(police);
		boxTexteTitre.add(texteTitre);		
		boxLivre.add(aeraMonHistoire);

		boxMiseEnPage.add(boxTexteTitre);
		this.boxMiseEnPage.add(Box.createRigidArea(new Dimension(0, 10)));
		boxMiseEnPage.add(boxLivre);

		this.add(boxMiseEnPage);
		
	}

	public void afficherLivre() {
		texte = "";
		try {
			InputStream ips = new FileInputStream("./histoire.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				this.texte += ligne + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		aeraMonHistoire.setText(texte);
	}

}
