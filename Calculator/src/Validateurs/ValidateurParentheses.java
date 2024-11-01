package Validateurs;

public class ValidateurParentheses implements ValidateurExpression {
    @Override
    public boolean valider(String equation) {
        int compteur = 0;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '(') {
                compteur++;
            } else if (c == ')') {
                compteur--;
                if (compteur < 0) {
                    return false; // Parenthèses mal appariées
                }
            }
        }
        return compteur == 0; // Vérifie si toutes les parenthèses sont correctement appariées
    }
}
