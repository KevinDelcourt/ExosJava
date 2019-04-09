package expressions_logiques;

public class ExpressionLogiqueA3Variables {

	private TableDesSymboles symboles;
	public Satisfiable constructionEpressionLogiqueA3Variables() {
		this.symboles = new TableDesSymboles();
		VariableBool�enne a = new VariableBool�enne("a", "Sonnerie");
		this.symboles.addVariable(a);
		VariableBool�enne b = new VariableBool�enne("b", "D�cision de r�pondre");
		this.symboles.addVariable(b);
		VariableBool�enne c = new VariableBool�enne("c", "D�cision d'appeler");
		this.symboles.addVariable(c);
		OperandeBinaire conjonctionGauche = new And();
		OperandeUnaire nonA = new Not();
		nonA.setOperande(a);
		conjonctionGauche.setOperandeGauche(nonA);
		conjonctionGauche.setOperandeDroit(c);
		OperandeBinaire conjonctionDroite = new And();
		conjonctionDroite.setOperandeGauche(a);
		conjonctionDroite.setOperandeDroit(b);
		OperandeBinaire d�crocher = new Or();
		d�crocher.setOperandeGauche(conjonctionGauche);
		d�crocher.setOperandeDroit(conjonctionDroite);
		return d�crocher;
	}

	public void quandDecrocherSonTelephone(Satisfiable d�crocher) {
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			this.symboles.fixerValeurDeV�rit�(i,3);
			if (d�crocher.isSatisfiable()) {
				System.out.print("Je d�croche mon t�l�phone quand : ");
				for (int j = 0; j < 3; j++) {
					System.out.print(this.symboles.interpr�tation(j));
					if (j < 2)
						System.out.print(" et ");
				}
				System.out.println();
			}
		}
	}

	public void quandNePasDecrocherSonTelephone(Satisfiable d�crocher) {
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			this.symboles.fixerValeurDeV�rit�(i,3);
			if (!d�crocher.isSatisfiable()) {
				System.out.print("Je ne d�croche pas mon t�l�phone quand : ");
				for (int j = 0; j < 3; j++) {
					System.out.print(this.symboles.interpr�tation(j));
					if (j < 2)
						System.out.print(" et ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		ExpressionLogiqueA3Variables unClient = new ExpressionLogiqueA3Variables();
		Satisfiable d�crocher = unClient.constructionEpressionLogiqueA3Variables();
		System.out.print("Evaluation expression bool�enne : ");
		System.out.println(d�crocher);
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			unClient.symboles.fixerValeurDeV�rit�(i,3);
			System.out.println(d�crocher.isSatisfiable());
		}
		unClient.quandDecrocherSonTelephone(d�crocher);
		unClient.quandNePasDecrocherSonTelephone(d�crocher);
	}
}
