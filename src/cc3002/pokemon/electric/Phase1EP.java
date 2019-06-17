package cc3002.pokemon.electric;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

/**
 * Class that represents a electric type phase 1 Pokémon.
 *
 * @author Diego Sandoval Leiva
 */

public class Phase1EP extends AbstractElectricPokemon implements IElectricPokemon {
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public Phase1EP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    @Override
    public void getObjectType(Trainer trainer) {
        trainer.getActivePokemon().sendType1EP(trainer);
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
        else if (!(o instanceof Phase1EP)) return false;
        else return false;
    }
}
