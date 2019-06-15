package cc3002.pokemon.psychic;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.normal.AbstractNormalPokemon;
import cc3002.pokemon.normal.INormalPokemon;

import java.util.List;

public class BasicPP extends AbstractPsychicPokemon implements IPsychicPokemon{

    /**
     * Creates a new Fire Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected BasicPP(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }
}
