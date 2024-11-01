package TestJunit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Validateurs.ValidateurOperateurs;

public class TestValidateurOperateurs {
    
    @Test
    public void testOperateursValides() {
        ValidateurOperateurs validateur = new ValidateurOperateurs();
        
        assertTrue(validateur.valider("(3*4) - (6/2)"));
       assertTrue(validateur.valider("(3*4) + (6/2)"));
        assertTrue(validateur.valider("(3*4) * (6/2)"));
        assertTrue(validateur.valider("(3*4) / (6/2)"));
        assertTrue(validateur.valider("2 + 3"));
        assertTrue(validateur.valider("2 - 3"));
        assertTrue(validateur.valider("2 * 3"));
        assertTrue(validateur.valider("2 / 3"));
        assertTrue(validateur.valider("2 + 3"));
        assertTrue(validateur.valider("(2 + 3) * 4"));
        assertTrue(validateur.valider("2 + (3 * 4)"));
        assertTrue(validateur.valider("((-314)) * (2*8/2)+(27)"));
        assertTrue(validateur.valider("-2 + 3"));
       assertTrue(validateur.valider("(-2) + 3"));
        assertTrue(validateur.valider("17 / 2"));
        
    }
    
    @Test
    public void testOperateursNonValides() {
        ValidateurOperateurs validateur = new ValidateurOperateurs();
        
     //   assertFalse(validateur.valider("-2+1-"));
        assertFalse(validateur.valider("(3*4) ++ (6/2)"));
        assertFalse(validateur.valider("(3*4) -- (6/2)"));
        assertFalse(validateur.valider("2 ++ 3"));
        assertFalse(validateur.valider("2 -- 3"));
        assertFalse(validateur.valider("2 *(* 3)"));
        assertFalse(validateur.valider("2 +(*2)+ 3"));
        assertFalse(validateur.valider("2  3"));
        assertFalse(validateur.valider("2 + * 3"));
        assertFalse(validateur.valider("2 + / 3"));
        assertFalse(validateur.valider("2 +  3*"));
       assertFalse(validateur.valider("2 +"));
        assertFalse(validateur.valider("+ 3"));
    }
    
}
