package cc3002.pokemon.electric;

        import cc3002.pokemon.Abilities.IAbilities;
        import cc3002.pokemon.AbstractPokemon;

        import java.util.List;

        import cc3002.pokemon.normal.NormalAttack;

/**
 * Class that represents a electric type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractElectricPokemon extends AbstractPokemon implements IElectricPokemon {

    /**
     * Creates a new electric Pokémon.
     *  @param name  Pokémon's name.
     * @param id Pokémon's id.
     * @param hp  Pokémon's hit points.
     * @param abilitiesList  Pokémon's attacks.
     */
    protected AbstractElectricPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name,id, hp, abilitiesList);
    }

    @Override
    public void receiveNormalAttack(NormalAttack attack) {
        receiveWeaknessAttack(attack);
    }

}
