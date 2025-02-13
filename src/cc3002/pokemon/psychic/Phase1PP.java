package cc3002.pokemon.psychic;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

/**
 * Class that represents a psychic type phase 1 Pokémon.
 *
 * @author Diego Sandoval Leiva
 */

public class Phase1PP extends AbstractPsychicPokemon implements IPsychicPokemon{
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public Phase1PP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    /**
     * Checks equals type (ONLY TYPE)
     *
     * @param o The target Pokemon object
     * @return True if are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o || (o instanceof Phase1PP))
            return true;
        else
            return false;
    }
}
