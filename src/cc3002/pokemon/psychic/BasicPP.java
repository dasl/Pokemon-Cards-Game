package cc3002.pokemon.psychic;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

/**
 * Class that represents a psychic type basic Pokémon.
 *
 * @author Diego Sandoval Leiva
 */

public class BasicPP extends AbstractPsychicPokemon implements IPsychicPokemon{

    /**
     * Creates a new Fire Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public BasicPP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    @Override
    public void getObjectType(Trainer trainer) {
        trainer.getActivePokemon().sendTypeBPP(trainer);
    }

    /**
     * Cheacks equals type (ONLY TYPE)
     *
     * @param o The target Pokemon object
     * @return True if are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof BasicPP)) return false;
        else return false;
    }
}
