package Calculatrice;

import java.util.Stack;

public class TransformateurInfixeVersPostfixe implements TransformateurExpression {

	public String transformer(String equation) {
	    StringBuilder postfixe = new StringBuilder();
	    Stack<Character> pileOperateurs = new Stack<>();

	    for (int i = 0; i < equation.length(); i++) {
	        char c = equation.charAt(i);

	        if (Character.isWhitespace(c)) {
	            continue;
	        }

	        if (Character.isDigit(c) || c == '.') {
	            int j = i;
	            while (j < equation.length() && (Character.isDigit(equation.charAt(j)) || equation.charAt(j) == '.')) {
	                j++;
	            }
	            postfixe.append(equation.substring(i, j));
	            postfixe.append(' ');
	            i = j - 1;
	        } else if (c == '(') {
	            pileOperateurs.push(c);
	        } else if (c == ')') {
	            while (!pileOperateurs.isEmpty() && pileOperateurs.peek() != '(') {
	                postfixe.append(pileOperateurs.pop());
	                postfixe.append(' ');
	            }
	            pileOperateurs.pop();
	        } else {
	            if (c == '-' && (i == 0 || equation.charAt(i - 1) == '(')) {
	                postfixe.append('0').append(' '); // Ajoute un zéro pour les opérateurs unaires
	            } else {
	                while (!pileOperateurs.isEmpty() && prioriteOperateur(c) <= prioriteOperateur(pileOperateurs.peek())) {
	                    postfixe.append(pileOperateurs.pop());
	                    postfixe.append(' ');
	                }
	            }
	            pileOperateurs.push(c);
	        }
	    }

	    while (!pileOperateurs.isEmpty()) {
	        postfixe.append(pileOperateurs.pop());
	        postfixe.append(' ');
	    }

	    return postfixe.toString().trim();
	}

    private int prioriteOperateur(char operateur) {
        switch (operateur) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
