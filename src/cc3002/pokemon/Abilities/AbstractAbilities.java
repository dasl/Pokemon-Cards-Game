package cc3002.pokemon.Abilities;

public abstract class AbstractAbilities implements IAbilities {
    private String text;
    private String name;

    public AbstractAbilities(String name,String text){
        this.name = name;
        this.text = text;
    }

    @Override
    public void accept(IAbilityVisitor IAbilityVisitor){
        IAbilityVisitor.visitConcreteAbility(this);
    }

    @Override
    public String getName(){
        return this.name;
    }
}
