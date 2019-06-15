package cc3002.pokemon.electric;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.fire.IFirePokemon;

import java.util.List;

public class BasicEP extends AbstractElectricPokemon implements IElectricPokemon{

    /**
     * Creates a new Fire Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    public BasicEP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
