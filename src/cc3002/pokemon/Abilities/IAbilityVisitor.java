package cc3002.pokemon.Abilities;

public interface IAbilityVisitor {
    void visitAttack(AbstractAttack abstractAttack);
    void visitConcreteAbility(AbstractAbilities abstractAbilities);
}
