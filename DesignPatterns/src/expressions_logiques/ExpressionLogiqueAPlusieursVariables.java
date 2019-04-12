package expressions_logiques;

public class ExpressionLogiqueAPlusieursVariables {

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
	
	public Satisfiable constructionEpressionLogiqueA4Variables() {
		VariableBool�enne a = new VariableBool�enne("a", "argent");
		VariableBool�enne b = new VariableBool�enne("b", "les devoirs sont fait");
		VariableBool�enne c = new VariableBool�enne("c", "le transport commun est en greve");
		VariableBool�enne d = new VariableBool�enne("d", "la voiture est disponible");

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
			this.symboles.fixerValeurDeV�rit�(i,4);
			if(sortir.isSatisfiable())
				System.out.print("Je sors quand : ");
			else
				System.out.print("Je ne sors pas quand : ");
			for (int j = 0; j < 4; j++) {
				System.out.print(this.symboles.interpr�tation(j));
				if (j < 3)
					System.out.print(" et ");
			}
			System.out.println();

		}
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
		ExpressionLogiqueAPlusieursVariables unClient = new ExpressionLogiqueAPlusieursVariables();
		Satisfiable d�crocher = unClient.constructionEpressionLogiqueA3Variables();
		System.out.print("Evaluation expression bool�enne : ");
		System.out.println(d�crocher);
		for (int i = 0; i <= Math.pow(2,3) -1; i++) {
			unClient.symboles.fixerValeurDeV�rit�(i,3);
			System.out.println(d�crocher.isSatisfiable());
		}
		unClient.quandDecrocherSonTelephone(d�crocher);
		unClient.quandNePasDecrocherSonTelephone(d�crocher);
		
		System.out.println();

		Satisfiable sortir = unClient.constructionEpressionLogiqueA4Variables();
		unClient.quandSortirOuPas(sortir);
	}
}
