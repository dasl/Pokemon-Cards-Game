package cc3002.pokemon.psychic;

import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a Pyschic type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class PsychicAttack extends AbstractAttack {


    /**
     * Creates a new attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param text
     * @param costs
     */
    public PsychicAttack(String name, int baseDamage, String text, EnergyCounter costs) {
        super(name, baseDamage, text, costs);
    }

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receivePsychicAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicAttack && super.equals(obj);
    }
}
