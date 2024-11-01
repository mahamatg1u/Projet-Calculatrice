package Calculatrice;

public class Operation implements Expression {

    private final Expression gauche;
    private final Expression droite;
    private final Operateur operateur;

    public Operation(Expression gauche, Expression droite, Operateur operateur) {
        this.gauche = gauche;
        this.droite = droite;
        this.operateur = operateur;
    }

    @Override
    public double evaluer() {
        double gauche = this.gauche.evaluer();
        double droite = this.droite.evaluer();

        switch (operateur) {
            case ADDITION:
                return gauche + droite;
            case SOUSTRACTION:
                return gauche - droite;
            case MULTIPLICATION:
                return gauche * droite;
            case DIVISION:
                if (droite == 0) {
                    throw new ArithmeticException("Division par zéro");
                }
                return gauche / droite;
            default:
                throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
        }
    }
}
