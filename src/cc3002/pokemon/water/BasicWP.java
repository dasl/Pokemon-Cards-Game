package cc3002.pokemon.water;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

public class BasicWP extends AbstractWaterPokemon implements IWaterPokemon{

    /**
     * Creates a new Fire Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public BasicWP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    @Override
    public void getObjectType(Trainer trainer) {
        trainer.getActivePokemon().sendTypeBWP(trainer);
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
        else if (!(o instanceof BasicWP)) return false;
        else return false;
    }
}
