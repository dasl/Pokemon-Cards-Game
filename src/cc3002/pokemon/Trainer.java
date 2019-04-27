package cc3002.pokemon;

import java.util.List;


/**
 * Class that represents a Trainer.
 *
 * @author Diego Sandoval Leiva
 */

public class Trainer extends AbstractTrainer{

    private IPokemon ActivePoke;

    public Trainer(IPokemon ActivePoke, List<IPokemon> PokeDeckList) {
        super(ActivePoke, PokeDeckList);
    }



}
