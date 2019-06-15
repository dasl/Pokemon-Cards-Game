package cc3002.pokemon.fire;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.electric.AbstractElectricPokemon;
import cc3002.pokemon.electric.IElectricPokemon;

import java.util.List;

public class Phase2FP extends AbstractFirePokemon implements IFirePokemon{
    /**
     * Creates a new electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected Phase2FP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
