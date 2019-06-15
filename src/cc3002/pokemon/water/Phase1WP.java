package cc3002.pokemon.water;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.psychic.IPsychicPokemon;

import java.util.List;

public class Phase1WP extends AbstractWaterPokemon implements IWaterPokemon{
    /**
     * Creates a new electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected Phase1WP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
