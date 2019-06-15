package cc3002.pokemon.electric;

import cc3002.pokemon.Abilities.IAbilities;

import java.util.List;

public class BasicEP extends AbstractElectricPokemon implements IElectricPokemon{

    /**
     * Creates a new Fire Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public BasicEP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }
}
