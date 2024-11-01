package Calculatrice;

import Validateurs.ValidateurExpression;

public class Calculatrice {
    private final ValidateurExpression validateurSyntaxe;
    private final TransformateurExpression transformateur;
    private final EvaluateurPostfixe evaluateur;

    public Calculatrice(ValidateurExpression validateurSyntaxe, TransformateurExpression transformateur, EvaluateurPostfixe evaluateur) {
        this.validateurSyntaxe = validateurSyntaxe;
        this.transformateur = transformateur;
        this.evaluateur = evaluateur;
    }

    public double calculer(String equation) throws ExceptionArithmetique {
        if (!validateurSyntaxe.valider(equation)) {
            throw new ExceptionArithmetique("Syntaxe invalide");
        }
        String postfixe = transformateur.transformer(equation);
        return evaluateur.evaluer(postfixe);
    }
}
