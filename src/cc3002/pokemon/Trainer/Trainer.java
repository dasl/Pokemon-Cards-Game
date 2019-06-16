package cc3002.pokemon.Trainer;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;

import java.util.List;


/**
 * Class that represents a Trainer.
 *
 * @author Diego Sandoval Leiva
 */

public class Trainer extends AbstractTrainer {
    /**
     * Creates a new Trainer.
     *
     * @param ActivePoke  Pokémon's name.
     * @param PokeDeckList  Pokémon's hit points.
     */
    public Trainer(String name, IPokemon ActivePoke, List<IPokemon> PokeDeckList) {
        super(name,ActivePoke, PokeDeckList);
    }

    /**
     * Play a card to the game.
     *
     * @param card Card
     */
    public void play(ICard card) {
        card.setTrainer(this);
        card.play();
    }


}
