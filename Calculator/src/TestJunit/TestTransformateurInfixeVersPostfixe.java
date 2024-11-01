package TestJunit;

import org.junit.jupiter.api.Test;

import Calculatrice.TransformateurInfixeVersPostfixe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransformateurInfixeVersPostfixe {

    private final TransformateurInfixeVersPostfixe transformateur = new TransformateurInfixeVersPostfixe();

    @Test
    public void testTransformer() {
        // Expressions infixes et leurs équivalents postfixes attendus
        String[] expressionsInfixes = {
        	    "2 + 2",
        	    "(3 * 4) - (6 / 2)",
        	    "14 / 2",
        	    "2 * 3 - 4",
        	    "(5 + 3) / 2",
        	  "-2 * 6 + 9",
        	    "10 - (-5)",
        	    "(2 + 2) * (3 - 1)",
        	    "6 * (4 - 2) / 3",
        	    "2 + 2 + 2",
        	    "(3 + 5) * 2",
        	    "2 * (3 - 1) / 4",
        	    "(-2) + 5 * (8 - 6)",
        	    "10 / (2 * 5)",
        	    "(6 + 2) * (9 - 7)",
        	    "-4 * (-3) / (2 + 2)",
        	    "15 - 3 * (4 / 2)",
        	    "(2 + 3) * (6 - 4) / 2",
        	    "8 * (6 - 4) / 2",
        	    "12 - 4 * 2",
        	    "24 / (8 - 4)",
        	    "(10 - 4) * 2",
        	    "3 + 5 - 2",
        	    "6 / (3 * 2)",
        	    "(7 - 3) * (8 / 2)",
        	    "9 * (2 / 1)",
        	    "12 / (6 - 3)",
        	    "(4 + 6) * (9 - 7)",
        	    "2 + 3 + 5",
        	    "4 * (8 / 2)",
        	    "18 - 6 * 2",
        	    "16 / (8 - 4)",
        	    "(12 - 3) * 2",
        	    "6 + 9 - 3",
        	    "5 * (10 / 5)",
        	    "24 / (12 - 6)",
        	    "(8 + 2) * (5 - 3)",
        	    "10 * (4 / 2)",
        	    "20 - 4 * 3",
        	    "40 / (10 - 6)",
        	    "(14 - 6) * 2",
        	    "9 + 6 - 3",
        	    "7 * (14 / 7)",
        	    "28 / (14 - 7)",
        	    "(10 + 2) * (6 - 4)",
        	    "8 * (16 / 8)",
        	    "32 / (16 - 8)",
        	    "(18 - 6) * 2",
        	    "(3 * 4) - (6 / 2)",
        	    "-2 - 2",
        	    "(2 + 2) * (3 - 1)",
        	    "6 * (4 - 2) / 3",
        	    "6 * (4 - 2) / 3 * (4 + 2)",
        	   "(-2) + 5 * (8 - 6)",
        	    "-4 * (-3) / (2 + 2)",
        	    "15 - 3 * (4 / 2)"
        	};

        	String[] expressionsPostfixesAttendues = {
        	    "2 2 +",
        	    "3 4 * 6 2 / -",
        	    "14 2 /",
        	    "2 3 * 4 -",
        	    "5 3 + 2 /",
        	  "0 2 6 * - 9 +",
        	    "10 0 5 - -",
        	    "2 2 + 3 1 - *",
        	    "6 4 2 - * 3 /",
        	    "2 2 + 2 +",
        	    "3 5 + 2 *",
        	    "2 3 1 - * 4 /",
        	  "0 2 - 5 8 6 - * +",
        	    "10 2 5 * /",
        	    "6 2 + 9 7 - *",
        	   "0 4 0 3 - * 2 2 + / -",
        	    "15 3 4 2 / * -",
        	    "2 3 + 6 4 - * 2 /",
        	    "8 6 4 - * 2 /",
        	    "12 4 2 * -",
        	    "24 8 4 - /",
        	    "10 4 - 2 *",
        	    "3 5 + 2 -",
        	    "6 3 2 * /",
        	    "7 3 - 8 2 / *",
        	    "9 2 1 / *",
        	    "12 6 3 - /",
        	    "4 6 + 9 7 - *",
        	    "2 3 + 5 +",
        	    "4 8 2 / *",
        	    "18 6 2 * -",
        	    "16 8 4 - /",
        	    "12 3 - 2 *",
        	    "6 9 + 3 -",
        	    "5 10 5 / *",
        	    "24 12 6 - /",
        	    "8 2 + 5 3 - *",
        	    "10 4 2 / *",
        	    "20 4 3 * -",
        	    "40 10 6 - /",
        	    "14 6 - 2 *",
        	    "9 6 + 3 -",
        	    "7 14 7 / *",
        	    "28 14 7 - /",
        	    "10 2 + 6 4 - *",
        	    "8 16 8 / *",
        	    "32 16 8 - /",
        	    "18 6 - 2 *",
        	    "3 4 * 6 2 / -",
        	    "0 2 - 2 -",
        	    "2 2 + 3 1 - *",
        	    "6 4 2 - * 3 /",
        	    "6 4 2 - * 3 / 4 2 + *",
        	    "0 2 - 5 8 6 - * +",
        	   "0 4 0 3 - * 2 2 + / -",
        	    "15 3 4 2 / * -"
        	};


        // Vérification des résultats de la méthode transformer
        for (int i = 0; i < expressionsInfixes.length; i++) {
        	
            String expressionPostfixe = transformateur.transformer(expressionsInfixes[i]);
            assertEquals(expressionsPostfixesAttendues[i], expressionPostfixe);
        }
    }
}
