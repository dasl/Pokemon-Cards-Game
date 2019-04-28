package cc3002.pokemon;

import java.util.List;


/**
 * Class that represents a Trainer.
 *
 * @author Diego Sandoval Leiva
 */

public class Trainer extends AbstractTrainer{


    /**
     * Creates a new Trainer.
     *
     * @param ActivePoke  Pokémon's name.
     * @param PokeDeckList  Pokémon's hit points.
     */
    public Trainer(String name, IPokemon ActivePoke, List<IPokemon> PokeDeckList) {
        super(name,ActivePoke, PokeDeckList);
    }


}
