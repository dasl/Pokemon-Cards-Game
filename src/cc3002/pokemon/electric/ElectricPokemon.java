package cc3002.pokemon.electric;

        import cc3002.pokemon.AbstractPokemon;
        import cc3002.pokemon.IAttack;
        import java.util.List;

        import cc3002.pokemon.fire.FireAttack;
        import cc3002.pokemon.grass.GrassAttack;
        import cc3002.pokemon.normal.NormalAttack;
        import cc3002.pokemon.water.WaterAttack;
        import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a normal type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new normal Pokémon.
     *
     * @param name  Pokémon's name.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public ElectricPokemon(String name, int hp, List<IAttack> attackList) {
        super(name, hp, attackList);
    }

    @Override
    public void receiveNormalAttack(NormalAttack attack) {
        receiveWeaknessAttack(attack);
    }


}
