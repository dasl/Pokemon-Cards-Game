package cc3002.pokemon.normal;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

/**
 * Class that represents a Normal type basic Pokémon.
 *
 * @author Diego Sandovcal Leiva
 */

public class BasicNP extends AbstractNormalPokemon implements INormalPokemon{

    /**
     * Creates a new Normal Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public BasicNP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    @Override
    public void getObjectType(Trainer trainer) {
        trainer.getActivePokemon().sendTypeBNP(trainer);
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
        else if (!(o instanceof BasicNP)) return false;
        else return false;
    }
}
