package cc3002.pokemon;


import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

/**
 * This function is performed through an interface, whose main function is to act as an intermediary to implement a double disptach, such that they can be
 * apply the energies required for an attack, as well as the energies
 * added for a certain pokemon.
 *
 * @author Diego Sandoval Leiva
 */

public interface IEnergy extends ICard{

    /**
     * Get the name of Energy type.
     *
     */
    String getEnergyNameType();


    /**
     * Add an energy to an abilities
     * This is the handshake of the double dispatch
     *
     * @param abilities the abilities
     */
    void addInto(IAbilities abilities);


    /**
     * Add an energy to an abstractPokemon
     * This is the handshake of the double dispatch
     *
     */
    void addToPoke();

}
