package TestJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import Calculatrice.Calculatrice;
import Calculatrice.EvaluateurPostfixe;
import Calculatrice.TransformateurExpression;
import Calculatrice.TransformateurInfixeVersPostfixe;
import Calculatrice.ExceptionArithmetique;
import Validateurs.ValidateurExpression;
import Validateurs.ValidateurOperandes;
import Validateurs.ValidateurOperateurs;
import Validateurs.ValidateurParentheses;
import Validateurs.ValidateurSyntaxe;

public class CalculatriceTest {

    @Test
    public void testExpressionsValides() {
        ArrayList<ValidateurExpression> validateurs = new ArrayList<>();
        validateurs.add(new ValidateurParentheses());
        validateurs.add(new ValidateurOperateurs());
        validateurs.add(new ValidateurOperandes());

        ValidateurExpression validateurSyntaxe = new ValidateurSyntaxe(validateurs);
        TransformateurExpression transformateur = new TransformateurInfixeVersPostfixe();
        EvaluateurPostfixe evaluateur = new EvaluateurPostfixe();

        Calculatrice calculatrice = new Calculatrice(validateurSyntaxe, transformateur, evaluateur);

        String[] expressionsValides = { 
            "10 - (5)",
            "(((2)+2)/2*(2))",
            "2    +    2",
            "(3*4)+(6/2)",
            "14  / 2",
            "2 * 3 - 4",
            "(5 + 3) / 2",
            "-2 * 6 + 9",
            "10 + (-5)",
            "(2 + 2) * (3 - 1)",
            "((-314)) * (2*8/2)+(271)",
            "6 * (4 - 2) / 3-6 * (4 - 2) / 3 *(4+2)",
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
            
            "(18 - 6) * 2 - (5) / (4 - 2) * 32 / (16 - 8)",
            "4 * (3 / 2)",
            "(358 / 2) -5*9+(2*8/8)-(-2)/2*(5+3/8-9)/8*(7)*((78*2))"
        };

        for (String expression : expressionsValides) {
            try {
                double resultat = calculatrice.calculer(expression);
                assertEquals(resultat, calculatrice.calculer(expression));
                System.out.println(expression + " = " + resultat);
            } catch (ExceptionArithmetique e) {
                System.out.println(expression +": "+ e.getMessage());
            }
        }
    }

    @Test
    public void testExpressionsInvalides() {
        ArrayList<ValidateurExpression> validateurs = new ArrayList<>();
        validateurs.add(new ValidateurParentheses());
        validateurs.add(new ValidateurOperateurs());
        validateurs.add(new ValidateurOperandes());

        ValidateurExpression validateurSyntaxe = new ValidateurSyntaxe(validateurs);
        TransformateurExpression transformateur = new TransformateurInfixeVersPostfixe();
        EvaluateurPostfixe evaluateur = new EvaluateurPostfixe();

        Calculatrice calculatrice = new Calculatrice(validateurSyntaxe, transformateur, evaluateur);

        String[] expressionsInvalides = {
            "2++",
            "(4 + 3 *",
            "(2 + 3",
            "(2 + 2) -",
            "5 + 6 -",
            "(3 - 2) / (5 *",
            "9 / (-2 + 1)(-1)",
            "(4 - 1) /",
            "2 / (3 - ",
            "+3 - 2",
            "2 * / 5",
            "7 * (4 / ",
            "6 / (4 + ",
            "5 * 6 /",
            "(2 + 3) - 1)",
            "4 + (3 * 2 -",
            "(6 / 2) + 1)",
            "2 * (3 -) / 4",
            "3 * (2 +)",
            "(4 + 6 /)",
            "5 * (6 /",
            "(3 + 2) /",
            "(2 + 3)) - 1",
            "(2 +) * 3",
            "5 * (6 +)",
            "4 * (3 /)",
            "(2 + 3) * (6 -) / 2",
            "(4 + 6) / (2 -",
            "5 * (6 +)",
            "4 * (3 /)",
            "(5 / (4 - 2))-2+(3",
            "(3 + 2) /",
            "(2 + 3)) - 1",
            "(2 +) * 3",
            "5 * (6 +)",
            "4 * (3 /)",
            "(2 + 3) * (6 -) / 2",
            "(4 + 6) / (2 -",
            "5 * (6 +)",
            "4 * (3 /)",
            "(3 + 2) /",
            "(2 + 3)) - 1",
            "(2 +) * 3",
            "5 * (6 +)",
           
            
        };
              
        
        
      
        for (String expression : expressionsInvalides) {
            try {
                double resultat = calculatrice.calculer(expression);
                System.out.println(expression + " = " + resultat);
            } catch (ExceptionArithmetique e) {
                System.out.println(expression +": "+ e.getMessage());
            }
        }
        
    }
    
    
    
    
}
