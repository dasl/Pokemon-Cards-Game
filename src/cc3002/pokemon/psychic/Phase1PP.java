package cc3002.pokemon.psychic;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.normal.AbstractNormalPokemon;
import cc3002.pokemon.normal.INormalPokemon;

import java.util.List;

public class Phase1PP extends AbstractPsychicPokemon implements IPsychicPokemon{
    /**
     * Creates a new electric Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected Phase1PP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
