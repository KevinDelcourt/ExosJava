package graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanActionEtreVivant extends Panel {

	Entite entite;
	jeuRole.Bataille bataille = new jeuRole.Bataille();
	
	//Les listes déroulantes
	JComboBox choixPersonnage;
	JComboBox choixHumain;
	JComboBox choixDragon;
	JComboBox choixArme;

	// Les boxs
	Box boxMiseEnPage = Box.createVerticalBox();
	
	Box boxChoixPersonnage = Box.createVerticalBox();
	Box boxChoixDragon = Box.createHorizontalBox();
	Box boxChoixHumain = Box.createVerticalBox();

	Box boxChoixArme;
	Box boxLacherArme;

	private static final long serialVersionUID = 1L;

	public PanActionEtreVivant(Entite entite) {
		this.entite = entite;
	}

	public void initialisation() {
		// Définition de la couleur de fond
		this.setBackground(Color.ORANGE);

		final JButton boutonBataille = new JButton("Entrer dans la bataille");
		boutonBataille.setVisible(false);
		this.choixPersonnage = new JComboBox();

		this.boxChoixPersonnage.add(this.choixPersonnage);
		this.boxChoixPersonnage.add(boutonBataille);

		JLabel questionCibleHumaine = new JLabel(
				"Sur quel humain voulez-vous cracher du feu ?");
		this.choixHumain = new JComboBox();		

		this.choixHumain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int indiceHumain = choixHumain.getSelectedIndex();
				if (indiceHumain != 0 && indiceHumain > 0) {
					indiceHumain--;
					jeuRole.Homme humain = (jeuRole.Homme) 
							bataille.getHomme(indiceHumain);
					int indiceDragon = choixPersonnage.getSelectedIndex();
					indiceDragon--;
					jeuRole.Dragon dragon = (jeuRole.Dragon) entite
							.getEtreVivant(indiceDragon);
						dragon.cracheBouleFeu(humain);
					if (humain.isMort()) {
						entite.supprimerEtreVivant(humain);
					}
					miseAjourChoixPersonnage();
					actionDragon();
				}

			}
		});

		JLabel questionCibleDragon = new JLabel(
				"Quel dragon voulez-vous combattre ?");
		this.choixDragon = new JComboBox();

		this.choixDragon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int indiceDragon = choixDragon.getSelectedIndex();
				if (indiceDragon != 0 && indiceDragon > 0) {
					indiceDragon--;
					jeuRole.Dragon dragon = (jeuRole.Dragon) bataille.getDragon(indiceDragon);
					int indiceHumain = choixPersonnage.getSelectedIndex();
					indiceHumain--;
					jeuRole.Homme homme = (jeuRole.Homme) entite
							.getEtreVivant(indiceHumain);
					homme.combattre(dragon);
					if (dragon.isMort()) {
						entite.supprimerEtreVivant(dragon);
					}
					if (homme.isMort()) {
						entite.supprimerEtreVivant(homme);
					}
					miseAjourChoixPersonnage();
					actionHomme();
				}

			}
		});

		JLabel questionChoixArme = new JLabel("Quel arme voulez-vous prendre ?");
		this.choixArme = new JComboBox();

		this.choixArme.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int indiceArme = choixArme.getSelectedIndex();
				if (indiceArme != 0 && indiceArme > 0) {
					indiceArme--;
					jeuRole.Arme arme = entite.getArmes().get(indiceArme);
					int indiceHumain = choixPersonnage.getSelectedIndex();
					indiceHumain--;
					jeuRole.Homme homme = (jeuRole.Homme) entite
							.getEtreVivant(indiceHumain);
					homme.prendre(arme);
					if (homme.isMort()) {
						entite.supprimerEtreVivant(homme);
					}
					miseAjourChoixPersonnage();
					actionArme(homme);
					actionHomme();
				}

			}
		});
		
		JButton lacherArme = new JButton("Lache son arme");
		lacherArme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int tmp = choixPersonnage.getSelectedIndex();
					tmp--;
					if (entite.getEtreVivant(tmp) instanceof jeuRole.Homme) {
						jeuRole.Homme homme = (jeuRole.Homme) entite.getEtreVivant(tmp);
						if (homme.aUneArme()) {
							homme.lacher();
						}
						actionArme(homme);
					}
				
			}
		});

		this.boxChoixDragon.add(questionCibleHumaine);
		this.boxChoixDragon.add(Box.createRigidArea(new Dimension(5, 0)));
		this.boxChoixDragon.add(choixHumain);

		Box boxCombattreDragon = Box.createHorizontalBox();
		boxCombattreDragon.add(questionCibleDragon);
		boxCombattreDragon.add(Box.createRigidArea(new Dimension(5, 0)));
		boxCombattreDragon.add(choixDragon);

		

		this.choixPersonnage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boxChoixDragon.setVisible(false);
				boxChoixHumain.setVisible(false);
				int tmp = choixPersonnage.getSelectedIndex();
				if (tmp != 0 && tmp > 0) {
					tmp--;
					if (!bataille.isDansBataille(entite.getEtreVivant(tmp))) {
						boutonBataille.setVisible(true);
					} else {
						boutonBataille.setVisible(false);
						if (entite.getEtreVivant(tmp) instanceof jeuRole.Dragon) {
							boxChoixHumain.setVisible(false);
							boxChoixDragon.setVisible(true);
							actionDragon();
						} else {
							boxChoixDragon.setVisible(false);
							boxChoixHumain.setVisible(true);
							actionHomme();
							actionArme((jeuRole.Homme)entite.getEtreVivant(tmp));
						}
					}
				}
			}
		});

		boutonBataille.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int tmp = choixPersonnage.getSelectedIndex();
				tmp--;
				entite.getEtreVivant(tmp).rejointBataille(bataille);
				boutonBataille.setVisible(false);
				miseAjourChoixPersonnage();
			}
		});

		this.boxChoixArme = Box.createHorizontalBox();
		this.boxChoixArme.add(questionChoixArme);
		this.boxChoixArme.add(Box.createRigidArea(new Dimension(5, 0)));
		this.boxChoixArme.add(choixArme);
		this.boxLacherArme = Box.createHorizontalBox();
		this.boxLacherArme.add(lacherArme);

		this.boxChoixHumain.add(boxCombattreDragon);
		this.boxChoixHumain.add(boxChoixArme);
		this.boxChoixHumain.add(boxLacherArme);

		this.boxMiseEnPage.add(boxChoixPersonnage);
		this.boxMiseEnPage.add(boxChoixDragon);
		this.boxMiseEnPage.add(boxChoixHumain);

		this.boxChoixDragon.setVisible(false);
		this.boxChoixHumain.setVisible(false);

		this.add(boxMiseEnPage);
	}

	public void miseAjourChoixPersonnage() {
		this.choixPersonnage.removeAllItems();
		this.choixPersonnage.addItem("Choisisser votre personnage");
		for (jeuRole.EtreVivant etreVivant : this.entite.getEtreVivants()) {
			this.choixPersonnage.addItem(etreVivant.getNom());
		}
	}

	private void actionDragon() {
		this.choixHumain.removeAllItems();
		this.choixHumain.addItem("Choisisser votre cible");
		for (String nomHomme : this.bataille.nomsCampHomme()) {
			this.choixHumain.addItem(nomHomme);
		}
	}

	private void actionHomme() {
		this.choixDragon.removeAllItems();
		this.choixDragon.addItem("Choisisser votre cible");
		for (String nomDragon : this.bataille.nomsCampDragon()) {
			this.choixDragon.addItem(nomDragon);
		}
	}

	private void actionArme(jeuRole.Homme homme) {
			if (!homme.aUneArme()) {
				this.choixArme.removeAllItems();
				this.choixArme.addItem("Choisisser votre arme");
				for (jeuRole.Arme arme : this.entite.getArmes()) {
					if (arme instanceof jeuRole.Epee) {
						jeuRole.Epee epee = (jeuRole.Epee) arme;
						this.choixArme.addItem("L'épée " + epee.getNom());
					} else
						this.choixArme.addItem(arme.getNature());
				}
				this.boxChoixArme.setVisible(true);
				this.boxLacherArme.setVisible(false);
			}
			else {
				this.boxChoixArme.setVisible(false);
				this.boxLacherArme.setVisible(true);
			}

	}

}
