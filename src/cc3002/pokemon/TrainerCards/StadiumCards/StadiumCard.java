package cc3002.pokemon.TrainerCards.StadiumCards;

import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

/**
 * This class represents a generic stadium card. This class contains the necessary methods to
 * play a stadiumcard.
 *
 * @author Diego Sandoval Leiva
 */

public class StadiumCard extends AbstractTrainerCard {
    private String type = "StadiumCard";
    public StadiumCard(String name, String text) {
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
