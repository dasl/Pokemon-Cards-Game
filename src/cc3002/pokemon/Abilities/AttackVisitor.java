package cc3002.pokemon.Abilities;

public class AttackVisitor implements IAbilityVisitor {
    AbstractAttack abstractAttack;
    @Override
    public void visitAttack(AbstractAttack abstractAttack) {
        this.abstractAttack = abstractAttack;
    }

    @Override
    public void visitConcreteAbility(AbstractAbilities abstractAbilities) { }


    public AbstractAttack getAttack(){
        return abstractAttack;
    }
}
