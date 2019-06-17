package cc3002.pokemon.electric;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

/**
 * Class that represents a electric type phase 2 Pokémon.
 *
 * @author Diego Sandoval Leiva
 */

public class Phase2EP extends AbstractElectricPokemon implements IElectricPokemon {
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public Phase2EP(String name, int id, int hp, List<IAbilities> abilitiesList) {
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
        if (this == o || (o instanceof Phase2EP))
            return true;
        else
            return false;
    }
}
