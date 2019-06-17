package cc3002.pokemon.Abilities.attacks;


import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;

import java.util.Random;

/**
 * ElectricShock contains the required methods to use this ability.
 *
 * @author Diego Sandoval Leiva
 */

public class ElectricShock extends AbstractAttack {
    private Random coin = new Random();

    /**
     * Creates a new attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param text
     * @param costs
     */
    public ElectricShock(String name, int baseDamage, String text, EnergyCounter costs) {
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
        other.receiveElectricShockAttack(this);
    }
}


