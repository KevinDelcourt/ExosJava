package expressions_logiques;

public class ExpressionLogiqueAPlusieursVariables {

	private TableDesSymboles symboles;
	public Satisfiable constructionEpressionLogiqueA3Variables() {
		this.symboles = new TableDesSymboles();
		VariableBooléenne a = new VariableBooléenne("a", "Sonnerie");
		this.symboles.addVariable(a);
		VariableBooléenne b = new VariableBooléenne("b", "Décision de répondre");
		this.symboles.addVariable(b);
		VariableBooléenne c = new VariableBooléenne("c", "Décision d'appeler");
		this.symboles.addVariable(c);
		OperandeBinaire conjonctionGauche = new And();
		OperandeUnaire nonA = new Not();
		nonA.setOperande(a);
		conjonctionGauche.setOperandeGauche(nonA);
		conjonctionGauche.setOperandeDroit(c);
		OperandeBinaire conjonctionDroite = new And();
		conjonctionDroite.setOperandeGauche(a);
		conjonctionDroite.setOperandeDroit(b);
		OperandeBinaire décrocher = new Or();
		décrocher.setOperandeGauche(conjonctionGauche);
		décrocher.setOperandeDroit(conjonctionDroite);
		return décrocher;
	}
	
	public Satisfiable constructionEpressionLogiqueA4Variables() {
		VariableBooléenne a = new VariableBooléenne("a", "argent");
		VariableBooléenne b = new VariableBooléenne("b", "les devoirs sont fait");
		VariableBooléenne c = new VariableBooléenne("c", "le transport commun est en greve");
		VariableBooléenne d = new VariableBooléenne("d", "la voiture est disponible");

		this.symboles = new TableDesSymboles();
		symboles.addVariable(a);
		symboles.addVariable(b);
		symboles.addVariable(c);
		symboles.addVariable(d);
		
		OperandeBinaire conjonctionGauche = new And();
		conjonctionGauche.setOperandeGauche(a);
		conjonctionGauche.setOperandeDroit(b);
		

		OperandeBinaire conjonctionDroite = new Or();
		OperandeUnaire nonC = new Not();
		nonC.setOperande(c);
		conjonctionDroite.setOperandeGauche(nonC);
		conjonctionDroite.setOperandeDroit(d);
		
		OperandeBinaire sortir = new And();
		sortir.setOperandeGauche(conjonctionGauche);
		sortir.setOperandeDroit(conjonctionDroite);
		return sortir;
	}

	public void quandSortirOuPas(Satisfiable sortir) {
		for(int i = 0; i < Math.pow(2, 4); i++) {
			this.symboles.fixerValeurDeVérité(i,4);
			if(sortir.isSatisfiable())
				System.out.print("Je sors quand : ");
			else
				System.out.print("Je ne sors pas quand : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(this.symboles.interprétation(j));
				if (j < 3)
					System.out.print(" et ");
			}
			System.out.println();

		}
	}
	
	public void quandDecrocherSonTelephone(Satisfiable décrocher) {
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			this.symboles.fixerValeurDeVérité(i,3);
			if (décrocher.isSatisfiable()) {
				System.out.print("Je décroche mon téléphone quand : ");
				for (int j = 0; j < 3; j++) {
					System.out.print(this.symboles.interprétation(j));
					if (j < 2)
						System.out.print(" et ");
				}
				System.out.println();

			}
		}
	}

	public void quandNePasDecrocherSonTelephone(Satisfiable décrocher) {
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			this.symboles.fixerValeurDeVérité(i,3);
			if (!décrocher.isSatisfiable()) {
				System.out.print("Je ne décroche pas mon téléphone quand : ");
				for (int j = 0; j < 3; j++) {
					System.out.print(this.symboles.interprétation(j));
					if (j < 2)
						System.out.print(" et ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		ExpressionLogiqueAPlusieursVariables unClient = new ExpressionLogiqueAPlusieursVariables();
		Satisfiable décrocher = unClient.constructionEpressionLogiqueA3Variables();
		System.out.print("Evaluation expression booléenne : ");
		System.out.println(décrocher);
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			unClient.symboles.fixerValeurDeVérité(i,3);
			System.out.println(décrocher.isSatisfiable());
		}
		unClient.quandDecrocherSonTelephone(décrocher);
		unClient.quandNePasDecrocherSonTelephone(décrocher);
		
		System.out.println();

		Satisfiable sortir = unClient.constructionEpressionLogiqueA4Variables();
		unClient.quandSortirOuPas(sortir);
	}
}
