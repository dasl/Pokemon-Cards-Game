package cc3002.pokemon.normal;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

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
}
