package cc3002.pokemon.electric;


import cc3002.pokemon.Abilities.AbstractAttack;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a electric type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class ElectricAttack extends AbstractAttack {

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     */
    public ElectricAttack(String name, int baseDamage,String text ) {
        super(name, baseDamage, text);
    }

    /**
     * Performs a electric type attack.
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveElectricAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricAttack && super.equals(obj);
    }



}
