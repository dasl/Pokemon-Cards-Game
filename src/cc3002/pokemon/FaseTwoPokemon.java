package cc3002.pokemon;

import java.util.List;

public class FaseTwoPokemon extends AbstractPokemon implements Evolutions {
    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param id
     * @param hp         Pokémon's hit points.
     * @param attackList Pokémon's attacks.
     */
    protected FaseTwoPokemon(String name, int id, int hp, List<IAttack> attackList) {
        super(name, id, hp, attackList);
    }

    @Override
    public void evoState() {
        System.out.println("Soy la fase dos jaja");
    }
}
