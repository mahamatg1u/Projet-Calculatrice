package TestJunit;
import org.junit.jupiter.api.Test;

import Calculatrice.EvaluateurPostfixe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEvaluateurPostfixe {

    private final EvaluateurPostfixe evaluateur = new EvaluateurPostfixe();

    @Test
    public void testEvaluation() {
         
    	 assertEquals(-0.8, evaluateur.evaluer("6 2 - 5 7 8 - * /"));
        assertEquals(8, evaluateur.evaluer("0 2 - 5 8 6 - * +"));
    }
}
