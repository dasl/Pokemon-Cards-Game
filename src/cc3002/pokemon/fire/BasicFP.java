package cc3002.pokemon.fire;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.electric.AbstractElectricPokemon;
import cc3002.pokemon.electric.IElectricPokemon;

import java.util.List;

public class BasicFP extends AbstractFirePokemon implements IFirePokemon{

    /**
     * Creates a new Fire Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    public BasicFP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
