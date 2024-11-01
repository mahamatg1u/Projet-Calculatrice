package Calculatrice;

public enum Operateur {
    ADDITION("+", 1),
    SOUSTRACTION("-", 1),
    MULTIPLICATION("*", 2),
    DIVISION("/", 2),
    PARENTHESE_OUVRANTE("(", 0),
    PARENTHESE_FERMANTE(")", 0);

    private final String symbole;
    private final int priorite;

    Operateur(String symbole, int priorite) {
        this.symbole = symbole;
        this.priorite = priorite;
    }

    public String getSymbole() {
        return symbole;
    }

    public int getPriorite() {
        return priorite;
    }

    public static Operateur fromSymbole(String symbole) {
        for (Operateur operateur : values()) {
            if (operateur.getSymbole().equals(symbole)) {
                return operateur;
            }
        }
        throw new IllegalArgumentException("Symbole invalide : " + symbole);
    }


    // Méthode pour vérifier si un caractère est un opérateur valide
    public static boolean estOperateurValide(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

	double appliquer(double gauche, double droite) {
		// TODO Auto-generated method stub
		return 0;
	}
}
