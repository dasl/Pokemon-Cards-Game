package cc3002.pokemon;

import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.Trainer.Trainer;


/**
 * Abstract class that represents a generic card. This class contains the necessary methods to
 * play any card, set and get trainer.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractCard implements ICard {
    private Trainer pokeMaster;

    /**
     * Play this pokemon card.
     */
    @Override
    public void play(){ }

    /**
     * Set the pokemon master owner of the energy.
     * @param trainer Received trainer.
     */
    @Override
    public void setTrainer(Trainer trainer) {
        this.pokeMaster=trainer;
    }


    /**
     * Get the pokemon master owner of the energy.
     */
    @Override
    public Trainer getTrainer() {
        return this.pokeMaster;
    }


    public abstract void accept(ICardVisitor visitor);
}
