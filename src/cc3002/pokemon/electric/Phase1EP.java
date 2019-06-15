package cc3002.pokemon.electric;

import cc3002.pokemon.IAttack;

import java.util.List;

public class Phase1EP extends AbstractElectricPokemon implements IElectricPokemon {
    /**
     * Creates a new electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected Phase1EP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
