package exo8;

public class Main {
	
	public static void main(String[] args) {
		
		// message � transmettre (Le b�teau ivre d'Arthur Rimbaud)
		Chaine[] trames = {
				new Chaine("Comme je descendais des fleuves impassibles"),
				new Chaine("Je ne me sentis plus guid� par les haleurs"),
				new Chaine("Des peaux-rouges criards les avaient pris pour cibles"),
				new Chaine("Les ayant clou�s nus aux poteaux de couleurs"),
				new Chaine("J'�tais insoucieux de tous les �quipages"),
				new Chaine("Porteur de bl�s flamands ou de cotons anglais"),
				new Chaine("Quand avec mes haleurs ont fini ces tapages"),
				new Chaine("Les fleuves m'ont laiss� descendre o� je voulais")
			};
		
		// transmettre le message
		ChaineAvecIndicateur transmis = trames[0].versChaineAvecIndicateur();
		for (int i = 1; i < trames.length; i++)
			transmis = transmis.concat(trames[i].versChaineAvecIndicateur());
		
		// recevoir le message
		Chaine recu = transmis.versChaine();
		System.out.println("Message recu : " + recu);
		if (! transmis.estValide()) {
			System.out.print("Derniers caracteres de la derniere trame :");
			for (int i = Chaine.LG_MAX - 20; i <= Chaine.LG_MAX - 1; i++)
				System.out.print(recu.getCharAt(i));
			System.out.println();
		}
	}

}
