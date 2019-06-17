package cc3002.pokemon;

import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.StadiumCards.StadiumCard;

import java.util.Observable;


/**
 * Abstract class that represents a generic card. This class contains the necessary methods to
 * play any card, set and get trainer.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractCard extends Observable implements ICard {
    private Trainer pokeMaster;
    private StadiumCard stadiumCard;

    /**
     * Notifiy to observers
     *
     */
    public void cardChanges(){
        setChanged();
        notifyObservers();
    }

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

    /**
     * Accept the card visitor.
     */
    public abstract void accept(ICardVisitor visitor);


    /**
     * Setter boolean of stadium card in game.
     */
    @Override
    public void setStadiumCard(StadiumCard stadiumCard){
        this.stadiumCard = stadiumCard;
        cardChanges();
    }

    /**
     * Getter of stadium card in game.
     * @return stadium
     */
    @Override
    public StadiumCard getStadiumCard(){
        return this.stadiumCard;
    }
}
