package cc3002.pokemon.TrainerCards.ObjectsCards;

/**
 * This class represents a GreatBall objects card.
 *
 * @author Diego Sandoval Leiva
 */

public class Potion extends ObjectsCard{

    public Potion(String name, String text) {
        super(name, text);
    }

    @Override
    public void play(){
        getTrainer().getSelectedPokemon().setHP(20);
        getTrainer().getSelectedPokemon().setObjectlinked(this);
        cardChanges();
    }
}
