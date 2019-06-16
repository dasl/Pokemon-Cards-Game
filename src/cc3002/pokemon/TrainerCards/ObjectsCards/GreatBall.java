package cc3002.pokemon.TrainerCards.ObjectsCards;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;

import java.util.Collections;

public class GreatBall extends ObjectsCard {
    public GreatBall(String name, String text) {
        super(name, text);
    }

    @Override
    public void play(){
        for(ICard poke : getTrainer().getDeck()){
            if(getTrainer().getSelectedPokemon().equals(poke)){
                getTrainer().addPokemonToBench((IPokemon) poke);
                getTrainer().getDeck().remove(poke);
                Collections.shuffle(getTrainer().getDeck());
                break;
            }
        }
    }

}
