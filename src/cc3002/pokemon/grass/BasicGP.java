package cc3002.pokemon.grass;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

public class BasicGP extends AbstractGrassPokemon implements IGrassPokemon{

    /**
     * Creates a new Fire Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public BasicGP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }
}
