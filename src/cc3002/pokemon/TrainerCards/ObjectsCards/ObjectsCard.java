package cc3002.pokemon.TrainerCards.ObjectsCards;

import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

/**
 * This class represents a generic objects card. This class contains the necessary methods to
 * play a objectscard.
 *
 * @author Diego Sandoval Leiva
 */


public class ObjectsCard extends AbstractTrainerCard {
    private String type = "ObjectsCard";

    public ObjectsCard(String name, String text) {
        super(name, text);
    }

    /**
     * Getter of string type of card. Is not using to disambiguate
     *
     * @return type
     */
    @Override
    public String getCardType() {
        return type;
    }
}
