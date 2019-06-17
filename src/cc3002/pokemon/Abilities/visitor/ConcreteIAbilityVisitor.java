package cc3002.pokemon.Abilities.visitor;

import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.Abilities.otherAbilities.AbstractAbilities;

public class ConcreteIAbilityVisitor implements IAbilityVisitor {
    AbstractAbilities visitador;

    @Override
    public void visitAttack(AbstractAttack abstractAttack) {}

    @Override
    public void visitConcreteAbility(AbstractAbilities abstractAbilities) {
        this.visitador = abstractAbilities;
    }

    public AbstractAbilities getAbility(){
        return visitador;
    }

}
