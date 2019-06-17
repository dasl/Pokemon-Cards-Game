package cc3002.pokemon.TrainerCards.SupportCards;

import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

/**
 * This class represents a generic support card. This class contains the necessary methods to
 * play a support card.
 *
 * @author Diego Sandoval Leiva
 */

public class SupportCard extends AbstractTrainerCard {
    private String type = "SupportCard";

    public SupportCard(String name, String text) {
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
