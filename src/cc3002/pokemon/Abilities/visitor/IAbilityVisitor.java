package cc3002.pokemon.Abilities.visitor;

import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.Abilities.otherAbilities.AbstractAbilities;

public interface IAbilityVisitor {
    void visitAttack(AbstractAttack abstractAttack);
    void visitConcreteAbility(AbstractAbilities abstractAbilities);

}
