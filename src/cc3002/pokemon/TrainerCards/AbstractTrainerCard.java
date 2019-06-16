package cc3002.pokemon.TrainerCards;

import cc3002.pokemon.AbstractCard;

public abstract class AbstractTrainerCard extends AbstractCard {
    private String name;
    private String text;

    public AbstractTrainerCard(String name, String text){
        this.name = name;
        this.text = text;
    }

}
