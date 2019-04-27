package cc3002.pokemon;


/**
 * Abstract class that represents a generic Energy. This class contains the necessary methods to
 * create an energy and get the card type.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractEnergy implements IEnergy {
    private IEnergy typeEnegy;
    private String typeCard;

    /**
     * Creates a new energy.
     *
     */
    protected AbstractEnergy() {
        this.typeCard = "Energy";
    }

    /**
     * Get the Card Type
     *
     */

    @Override
    public String getCardType() {
        return this.typeCard;
    }

}
