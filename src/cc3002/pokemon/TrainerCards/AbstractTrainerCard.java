package cc3002.pokemon.TrainerCards;

import cc3002.pokemon.AbstractCard;
import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.ICard;

public abstract class AbstractTrainerCard extends AbstractCard implements ICard {
    private String name;
    private String text;

    public AbstractTrainerCard(String name, String text){
        this.name = name;
        this.text = text;
    }

    @Override
    public void accept(ICardVisitor visitor){
        visitor.visitTrainerCard(this);
    }

    /**
     * Play this pokemon card.
     */
    @Override
    public void play(){ }

}
