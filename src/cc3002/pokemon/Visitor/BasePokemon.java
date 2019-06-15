package cc3002.pokemon.Visitor;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;

import java.util.List;

public class BasePokemon extends AbstractPokemon implements IEvolutions {

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected BasePokemon(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }

    @Override
    public void evoState() {
        System.out.println("Soy el estado base jaja");
    }
}
