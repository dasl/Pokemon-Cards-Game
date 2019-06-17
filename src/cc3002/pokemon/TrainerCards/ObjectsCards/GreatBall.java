package cc3002.pokemon.TrainerCards.ObjectsCards;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;

import java.util.Collections;


/**
 * This class represents a GreatBall objects card.
 *
 * @author Diego Sandoval Leiva
 */

public class GreatBall extends ObjectsCard {
    public GreatBall(String name, String text) {
        super(name, text);
    }

    @Override
    public void play(){
        for(ICard poke : getTrainer().getDeck()){
            if(getTrainer().getSelectedPokemon().equals(poke)){
                getTrainer().addPokemonToBench((IPokemon) poke);
                getTrainer().removefromDeck((poke));
                getTrainer().shuffleDeck();
                break;
            }
        }
    }

}
