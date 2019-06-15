package cc3002.pokemon.fire;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

public class Phase2FP extends AbstractFirePokemon implements IFirePokemon{
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    protected Phase2FP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }
}
