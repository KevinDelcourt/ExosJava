package graphique;

import java.awt.CardLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LivreFrame extends JFrame {

	private Entite entite = new Entite();
	
	private JPanel panContents = new JPanel();
	private PanHistoire panHistoire = new PanHistoire();
	private PanNouveauxEtresVivants panNouveauxEtresVivants = new PanNouveauxEtresVivants(entite);
	private PanActionEtreVivant panActionEtresVivants = new PanActionEtreVivant(entite);
	
	private MenuBar barreMenu;
	
	private CardLayout cartes = new CardLayout();
	
	
	
	public LivreFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		this.setTitle("Menu du livre");
		this.setSize(600, 600);
		
		
		
		panNouveauxEtresVivants.initialisation();
		panActionEtresVivants.initialisation();
		panHistoire.initialisation();
		
		panContents.setLayout(cartes);
		
		panContents.add(panNouveauxEtresVivants, "NOUVEAU");
		panContents.add(panActionEtresVivants, "ACTION");
		panContents.add(panHistoire, "HISTOIRE");
		
		
		this.getContentPane().add(panContents);
		
		InitialisationMenu();
		this.setMenuBar(barreMenu);
		
		this.setVisible(true);
	}
	
	private void InitialisationMenu(){
		barreMenu = new MenuBar();
		
		MenuItem menuCreation = new MenuItem("Création personnage");
		MenuItem menuAction = new  MenuItem("Action personnage");
		MenuItem menuHistoire = new  MenuItem("Histoire");
		
		menuCreation.addActionListener(
				new ActionListener() {   
					public void actionPerformed(ActionEvent event) {     
						cartes.show(panContents, "NOUVEAU");    
						}  
					}); 
		
		menuAction.addActionListener(
				new ActionListener() {   
					public void actionPerformed(ActionEvent event) {     
						cartes.show(panContents, "ACTION");    
						}  
					}); 
		
		menuHistoire.addActionListener(
				new ActionListener() {   
					public void actionPerformed(ActionEvent event) {     
						cartes.show(panContents, "HISTOIRE");    
						}  
					}); 
		
		Menu menu = new Menu("Menu");
		menu.add( menuCreation );
		menu.add( menuAction );
		menu.add( menuHistoire );
		
		barreMenu.add(menu);
	}
}
