package cc3002.pokemon.psychic;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import java.util.List;

import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a psychic type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new psychic Pokémon.
     *
     * @param name  Pokémon's name.
     * @param id  Pokémon's id.
     * @param hp  Pokémon's hit points.
     * @param attackList  Pokémon's attacks.
     */
    public PsychicPokemon(String name,int id ,int hp, List<IAttack> attackList) {
        super(name,id, hp, attackList);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        receiveWeaknessAttack(attack);
    }


    @Override
    public void receiveNormalAttack(NormalAttack attack) {
        receiveResistantAttack(attack);
    }


}
