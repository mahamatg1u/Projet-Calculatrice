package Validateurs;

import java.util.ArrayList;

public class ValidateurSyntaxe implements ValidateurExpression {
    private final ArrayList<ValidateurExpression> validateurs;

    public ValidateurSyntaxe(ArrayList<ValidateurExpression> validateurs) {
        this.validateurs = validateurs;
    }

    @Override
    public boolean valider(String equation) {
        for (ValidateurExpression validateur : validateurs) {
            if (!validateur.valider(equation)) {
                return false;
            }
        }
        return true;
    }
}
