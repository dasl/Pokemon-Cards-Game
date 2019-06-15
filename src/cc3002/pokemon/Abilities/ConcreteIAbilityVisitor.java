package cc3002.pokemon.Abilities;

public class ConcreteIAbilityVisitor implements IAbilityVisitor {
    AbstractAbilities visitador;

    @Override
    public void visitAttack(AbstractAttack abstractAttack) { }

    @Override
    public void visitConcreteAbility(AbstractAbilities abstractAbilities) {
        this.visitador = abstractAbilities;
    }

    public AbstractAbilities getAbility(){
        return visitador;
    }

    public String visitedNameAbility(){
        return visitador.getName();
    }
}
