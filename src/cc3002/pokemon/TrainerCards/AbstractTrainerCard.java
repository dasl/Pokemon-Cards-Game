package cc3002.pokemon.TrainerCards;

import cc3002.pokemon.AbstractCard;
import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.ICard;

/**
 * Abstract class that represents a generic trainer card. This class contains the necessary methods to
 * play a trainercard.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractTrainerCard extends AbstractCard implements ICard {
    private String name;
    private String text;

    public AbstractTrainerCard(String name, String text){
        this.name = name;
        this.text = text;
    }

    /**
     * Accept card visitor
     *
     */
    @Override
    public void accept(ICardVisitor visitor){
        visitor.visitTrainerCard(this);
    }


}
