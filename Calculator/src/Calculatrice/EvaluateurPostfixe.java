package Calculatrice;

import java.util.Stack;

public class EvaluateurPostfixe {
    public double evaluer(String postfixe) {
        String[] elements = postfixe.split("\\s+");
        Stack<Double> pile = new Stack<>();

        for (String element : elements) {
            if (element.isEmpty()) {
                continue;
            }

            try {
                double nombre = Double.parseDouble(element);
                pile.push(nombre);
            } catch (NumberFormatException e) {
                char c = element.charAt(0);
                Operateur operateur = Operateur.fromSymbole(Character.toString(c));

                if (operateur == null) {
                    throw new IllegalArgumentException("Élément invalide dans l'expression postfixe : " + element);
                }

                if (pile.size() < 2) {
                    throw new IllegalArgumentException("Nombre insuffisant d'opérandes pour l'opérateur : " + operateur.getSymbole());
                }

                double droite = pile.pop();
                double gauche = pile.pop();
                double resultat = 0;

                switch (operateur) {
                    case ADDITION:
                        resultat = gauche + droite;
                        break;
                    case SOUSTRACTION:
                        resultat = gauche - droite;
                        break;
                    case MULTIPLICATION:
                        resultat = gauche * droite;
                        break;
                    case DIVISION:
                        if (droite == 0) {
                            throw new ArithmeticException("Division par zéro");
                        }
                        resultat = gauche / droite;
                        break;
                    default:
                        throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
                }

                pile.push(resultat);
            }
        }

        if (pile.size() != 1) {
            throw new IllegalArgumentException("Nombre incorrect d'éléments dans la pile après l'évaluation de l'expression postfixe");
        }

        return pile.pop();
    }
}
