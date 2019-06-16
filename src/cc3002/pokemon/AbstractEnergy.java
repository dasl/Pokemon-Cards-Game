package cc3002.pokemon;


import cc3002.pokemon.CardVisitor.ICardVisitor;

/**
 * Abstract class that represents a generic Energy. This class contains the necessary methods to
 * create an energy and get the card type.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractEnergy extends AbstractCard implements IEnergy {
    private String typeCard;


    /**
     * Creates a new energy.
     *
     */
    protected AbstractEnergy() {
        this.typeCard = "Energy";
    }


    @Override
    public void accept(ICardVisitor visitor){
        visitor.visitEnergyCard(this);
    }

    /**
     * Play this pokemon card.
     */
    @Override
    public void play(){ }

    /**
     * Get the Card Type
     *
     */
    @Override
    public String getCardType() {
        return this.typeCard;
    }

}
