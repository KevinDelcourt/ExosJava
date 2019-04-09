package expressions_logiques;

public class ExpressionLogiqueA3Variables {

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
		ExpressionLogiqueA3Variables unClient = new ExpressionLogiqueA3Variables();
		Satisfiable décrocher = unClient.constructionEpressionLogiqueA3Variables();
		System.out.print("Evaluation expression booléenne : ");
		System.out.println(décrocher);
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			unClient.symboles.fixerValeurDeVérité(i,3);
			System.out.println(décrocher.isSatisfiable());
		}
		unClient.quandDecrocherSonTelephone(décrocher);
		unClient.quandNePasDecrocherSonTelephone(décrocher);
	}
}
