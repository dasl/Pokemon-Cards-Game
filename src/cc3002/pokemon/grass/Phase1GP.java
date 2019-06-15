package cc3002.pokemon.grass;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

public class Phase1GP extends AbstractGrassPokemon implements IGrassPokemon{
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    protected Phase1GP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }
}
