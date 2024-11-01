package Validateurs;

import Calculatrice.Operateur;

public class ValidateurOperateurs implements ValidateurExpression {

    @Override
    public boolean valider(String equation) {
        boolean operateurPrecedent = true; // Opérateur valide attendu au début
        boolean debutExpression = true; // Indicateur de début de l'expression
        boolean nombreNegatif = false; // Indicateur d'un nombre négatif

        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (Character.isWhitespace(c) || c == '(' || c == ')') {
                // Passez au caractère suivant s'il s'agit d'un espace ou d'une parenthèse
                debutExpression = false;
                nombreNegatif = false;
                continue;
            } else if (Character.isDigit(c)) {
                // Si le caractère est un chiffre, alors un opérateur doit venir ensuite ou un autre chiffre pour former un nombre
                if (!operateurPrecedent && !nombreNegatif) {
                    return false;
                }
                operateurPrecedent = false;
                nombreNegatif = false;

                // Vérifiez si le caractère suivant est aussi un chiffre
                if (i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1))) {
                    // Passez aux chiffres suivants
                    i++;
                    while (i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1))) {
                        i++;
                    }
                }
            } else if (Operateur.estOperateurValide(c)) {
                // Si le caractère est un opérateur, alors un chiffre ou une parenthèse doit venir avant
                if (operateurPrecedent) {
                    // Vérifie si l'opérateur est '-' et s'il est au début de l'expression ou après une parenthèse ouvrante
                    if (c == '-' && (debutExpression || equation.charAt(i - 1) == '(')) {
                        // L'opérateur '-' est autorisé au début ou après une parenthèse ouvrante
                        nombreNegatif = true;
                    } else {
                        return false;
                    }
                } else {
                    operateurPrecedent = true;
                }
            } else {
                // Caractère non valide rencontré
                return false;
            }
        }

        // Vérifiez si l'expression se termine correctement
        if (operateurPrecedent) {
            return false;
        }

        // Si toutes les conditions sont satisfaites, l'expression est valide
        return true;
    }
}
