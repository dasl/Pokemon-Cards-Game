package cc3002.pokemon.psychic;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a normal type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new normal Pokémon.
     *
     * @param name  Pokémon's name.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public PsychicPokemon(String name, int hp, List<IAttack> attackList) {
        super(name, hp, attackList);
    }

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {receiveEnergy(energy);}
}
