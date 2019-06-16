package cc3002.pokemon.TrainerCards;

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
