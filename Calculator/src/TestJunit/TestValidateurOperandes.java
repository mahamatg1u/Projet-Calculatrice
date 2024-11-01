package TestJunit;
import Validateurs.ValidateurExpression;
import Validateurs.ValidateurOperandes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestValidateurOperandes {
    
    @Test
    void testOperandesValides() {
        ValidateurExpression validateur = new ValidateurOperandes();
        assertTrue(validateur.valider("2 + 3"));
        assertTrue(validateur.valider("(2)-2 - 2 / 2"));
        assertTrue(validateur.valider("((-314)) + (2*8/2)/(2.71)"));
       assertTrue(validateur.valider("((-314)) * (2*8*2)+(271)"));
        assertTrue(validateur.valider("10  - (5)"));
    }
   
    @Test
    void testOperandesInvalides() {
        ValidateurExpression validateur = new ValidateurOperandes();
         assertFalse(validateur.valider("24(4-18)/2")); 
        assertFalse(validateur.valider("(4 * ) / 2")); 
        assertFalse(validateur.valider("1*(2)-2+)")); 
    }
}
