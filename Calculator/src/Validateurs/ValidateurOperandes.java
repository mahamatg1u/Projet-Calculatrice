package Validateurs;

public class ValidateurOperandes implements ValidateurExpression {

    @Override
    public boolean valider(String equation) {
        boolean operandValide = false;
        boolean signeMoinsUnitaire = false;
        int parentheseOuvrante = 0;

        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (Character.isWhitespace(c)) {
                // Ignorer les espaces
                continue;
            }

            if (Character.isDigit(c)) {
                operandValide = true;
                signeMoinsUnitaire = false;
            } else if (c == '-') {
                if (i == 0 || equation.charAt(i - 1) == '(' || equation.charAt(i - 1) == '+' || equation.charAt(i - 1) == '-' || equation.charAt(i - 1) == '*' || equation.charAt(i - 1) == '/') {
                    // Permettre les opérandes négatives au début, après une parenthèse ouvrante ou après un opérateur
                    signeMoinsUnitaire = true;
                } else if (operandValide) {
                    // Permettre l'opérateur binaire moins après un opérande valide
                    operandValide = false;
                } else {
                    return false; // Opérande invalide
                }
            } else if (c == '(') {
                if (operandValide) {
                    return false; // Opérande invalide avant une parenthèse ouvrante
                }
                parentheseOuvrante++;
            } else if (c == ')') {
                if (!operandValide) {
                    return false; // Opérande invalide avant une parenthèse fermante
                }
                if (parentheseOuvrante == 0) {
                    return false; // Parenthèse fermante sans correspondance
                }
                parentheseOuvrante--;
            } else if (c == '.') {
                // Si le caractère est un point décimal, vérifier qu'il n'a pas déjà été rencontré
                if (!operandValide) {
                    return false; // Opérande invalide avec plusieurs points décimaux
                }
                operandValide = false; // Réinitialiser l'opérande valide pour éviter plusieurs points décimaux
            } else {
                operandValide = false;
            }
        }

        // Vérifier si la dernière expression est un opérande valide
        return (operandValide || signeMoinsUnitaire) && parentheseOuvrante == 0;
    }
}
