package cc3002.pokemon.water;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

public class Phase2WP extends AbstractWaterPokemon implements IWaterPokemon{
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    protected Phase2WP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }
}
