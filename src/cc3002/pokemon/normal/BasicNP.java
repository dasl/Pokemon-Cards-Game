package cc3002.pokemon.normal;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.grass.IGrassPokemon;

import java.util.List;

public class BasicNP extends AbstractNormalPokemon implements INormalPokemon{

    /**
     * Creates a new Normal Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    public BasicNP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
