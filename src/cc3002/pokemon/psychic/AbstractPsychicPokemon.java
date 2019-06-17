package cc3002.pokemon.psychic;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.AbstractPokemon;

import java.util.List;

import cc3002.pokemon.normal.NormalAttack;

/**
 * Class that represents a psychic type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractPsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new psychic Pokémon.
     *  @param name  Pokémon's name.
     * @param id Pokémon's id.
     * @param hp  Pokémon's hit points.
     * @param abilitiesList  Pokémon's attacks.
     */
    protected AbstractPsychicPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name,id,hp, abilitiesList);
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
