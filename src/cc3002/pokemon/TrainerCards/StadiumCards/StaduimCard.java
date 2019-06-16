package cc3002.pokemon.TrainerCards.StadiumCards;

import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

public class StaduimCard extends AbstractTrainerCard {
    private String type = "StadiumCard";
    public StaduimCard(String name, String text) {
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
