package TestJunit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Validateurs.ValidateurParentheses;

public class TestValidateurParentheses {
    
    @Test
    public void testParenthesesValides() {
        ValidateurParentheses validateur = new ValidateurParentheses();
        
        assertTrue(validateur.valider("(3*4) - (6/2)"));
        assertTrue(validateur.valider("((3*4) - (6/2))"));
        assertTrue(validateur.valider("((3*4) - ((6/2)))"));
        assertTrue(validateur.valider("(((3*4) - (6/2)))"));
    }
    
    @Test
    public void testParenthesesNonValides() {
        ValidateurParentheses validateur = new ValidateurParentheses();
        
        assertFalse(validateur.valider("(3*4 - (6/2)"));
        assertFalse(validateur.valider("(3*4) - 6/2)"));
        assertFalse(validateur.valider(")(3*4) - (6/2)("));
    }
}
