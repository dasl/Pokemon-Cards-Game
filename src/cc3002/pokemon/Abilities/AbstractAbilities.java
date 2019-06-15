package cc3002.pokemon.Abilities;

import cc3002.pokemon.AbstractCard;
import cc3002.pokemon.IPokemon;

public abstract class AbstractAbilities extends AbstractCard implements IAbilities {
    private String text;
    private String name;

    public AbstractAbilities(String name,String text){
        this.name = name;
        this.text = text;
    }

    @Override
    public void accept(IAbilityVisitor visitor){
        visitor.visitConcreteAbility(this);
    }


    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getCardType() {
        return null;
    }

    @Override
    public int getBaseDamage(){
        return -1;
    }

}
