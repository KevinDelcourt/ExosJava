package graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanNouveauxEtresVivants extends JPanel {

	
	private Entite entite;
	
	private static final long serialVersionUID = 1L;
	
	private Font pliceTitre = new Font( "Old English Text MT", Font.BOLD, 20);
	private Font policeARemplacer = new Font("Arial", Font.ITALIC, 12 );
	private Font policeChoixUtilisateur = new Font( "Arial", Font.TRUETYPE_FONT, 12 );

	public PanNouveauxEtresVivants(Entite entite) {
		this.entite = entite;
	}
	
	public void initialisation() {
		this.setBackground(Color.lightGray);
		
		JLabel textePersonnage = new JLabel("Nouveau Personnage");
		textePersonnage.setFont(pliceTitre);
		
		JLabel texteArme = new JLabel("Nouvelle Arme");
		texteArme.setFont(pliceTitre);
		
		Box boxMiseEnPage = Box.createVerticalBox();
				
		Box boxBoutonsArme = Box.createVerticalBox();
		Box boxBoutonsPersonnage = Box.createHorizontalBox();
		
		JTextArea areaNomPersonnage = new JTextArea(1,3);
		areaNomPersonnage.setFont(policeARemplacer);
		areaNomPersonnage.setForeground(Color.GRAY);
		areaNomPersonnage.setText("Nom du personnage");
		
		areaNomPersonnage.addMouseListener(
				new MouseListener() {        
					public void mouseReleased(MouseEvent arg0) {}    
					public void mousePressed(MouseEvent arg0) {}   
					public void mouseExited(MouseEvent arg0) {}    
					public void mouseEntered(MouseEvent arg0) {}    
					public void mouseClicked(MouseEvent arg0) {     
						areaNomPersonnage.setText(null);     
						areaNomPersonnage.setFont(policeChoixUtilisateur);     
						areaNomPersonnage.setForeground(Color.black);         
						}   
					});
		
		
		
		JTextArea areaInstructionArme = new JTextArea(1,3);
		areaInstructionArme.setFont(policeARemplacer);
		areaInstructionArme.setForeground(Color.GRAY);
		areaInstructionArme.setText("Arme");
		
		areaInstructionArme.addMouseListener(
				new MouseListener() {        
					public void mouseReleased(MouseEvent arg0) {}    
					public void mousePressed(MouseEvent arg0) {}   
					public void mouseExited(MouseEvent arg0) {}    
					public void mouseEntered(MouseEvent arg0) {}    
					public void mouseClicked(MouseEvent arg0) {     
						areaInstructionArme.setText(null);     
						areaInstructionArme.setFont(policeChoixUtilisateur);     
						areaInstructionArme.setForeground(Color.black);         
						}   
					});
		
		JComboBox<String> listeArme = new JComboBox<String>();
		listeArme.addItem("EPEE");
		listeArme.addItem("ARC");
		listeArme.addItem("LANCE PIERRE");
		
		listeArme.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {   
				int tmp = listeArme.getSelectedIndex();   
				if (tmp == 0) {    
					areaInstructionArme.setVisible(true);   
					areaInstructionArme.setText("Nom de l'épée");   
				}   
				if (tmp == 1){    
					areaInstructionArme.setVisible(true);   
					areaInstructionArme.setText("Nombre de flèches");
						
				}  
				if (tmp == 2) {   
					areaInstructionArme.setVisible(false); 
				}  
			} 
		}); 
		
		JButton nouveauDragon = new JButton( new ImageIcon("src/images/dragon.jpg"));
		
		nouveauDragon.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent e) {     
				String nom = areaNomPersonnage.getText();    
				if (nom.length() != 0) {      
					jeuRole.Dragon dragon = new jeuRole.Dragon(nom);     
					entite.ajouterEtreVivant(dragon);     
				}    
				areaNomPersonnage.setText("Nom du personnage");    
				areaNomPersonnage.setFont(policeARemplacer);     
				areaNomPersonnage.setForeground(Color.gray);    
				}   
			});
		
		JButton nouveauHomme = new JButton( new ImageIcon("src/images/humain.jpg"));
		
		nouveauHomme.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent e) {     
				String nom = areaNomPersonnage.getText();    
				if (nom.length() != 0) {      
					jeuRole.Homme homme = new jeuRole.Homme(nom);     
					entite.ajouterEtreVivant(homme);     
				}    
				areaNomPersonnage.setText("Nom du personnage");    
				areaNomPersonnage.setFont(policeARemplacer);     
				areaNomPersonnage.setForeground(Color.gray);    
				}   
			});
		
		JButton nouveauHeros = new JButton( new ImageIcon("src/images/hero.jpg"));
		
		nouveauHeros.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent e) {     
				String nom = areaNomPersonnage.getText();    
				if (nom.length() != 0) {      
					jeuRole.Heros heros = new jeuRole.Heros(nom);     
					entite.ajouterEtreVivant(heros);     
				}    
				areaNomPersonnage.setText("Nom du personnage");    
				areaNomPersonnage.setFont(policeARemplacer);     
				areaNomPersonnage.setForeground(Color.gray);    
				}   
			});
		
		JButton nouvelleArme = new JButton("Nouvelle arme");
		
		nouvelleArme.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {   
				int tmp = listeArme.getSelectedIndex();   
				if (tmp == 0) {    
					String nom = areaInstructionArme.getText();    
					if (nom.length() != 0 && !nom.equals("Nom de l'épée")) {     
						jeuRole.Epee epee = new jeuRole.Epee(nom);    
						entite.ajouterArme(epee);    
					}   
				}  
				if (tmp == 1) {   
					String chaineNbFleche = areaInstructionArme.getText();    
					if (!chaineNbFleche.equals("Nombre de flèches")) {     
						try {      
							int nbFleche = Integer.valueOf(chaineNbFleche);      
							jeuRole.Arc arc = new jeuRole.Arc(nbFleche);      
							entite.ajouterArme(arc);    
						} catch (NumberFormatException e2) {      
							System.out.println("Il faut entrer un chiffre !");     
							}    
						}   
					}   
				if (tmp == 2) {   
						jeuRole.LancePierre lancePierre = new jeuRole.LancePierre();   
						entite.ajouterArme(lancePierre);   }   
				areaInstructionArme.setFont(policeARemplacer);   
				areaInstructionArme.setForeground(Color.gray);   
				areaInstructionArme.setText("Nom de l'épée");   
				listeArme.setSelectedIndex(0);  
				} 
			}); 
		
		boxBoutonsArme.add(areaInstructionArme);
		boxBoutonsArme.add(listeArme);
		boxBoutonsArme.add(nouvelleArme);
		
		boxBoutonsPersonnage.add(nouveauDragon);
		boxBoutonsPersonnage.add(nouveauHomme);
		boxBoutonsPersonnage.add(nouveauHeros);
		
		boxMiseEnPage.add(textePersonnage);
		boxMiseEnPage.add(areaNomPersonnage);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0, 30))); 
		boxMiseEnPage.add(boxBoutonsPersonnage);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0, 30))); 
		
		boxMiseEnPage.add(texteArme);
		
		
		
		boxMiseEnPage.add(boxBoutonsArme);
		
		
		this.add(boxMiseEnPage); 
	}
}
