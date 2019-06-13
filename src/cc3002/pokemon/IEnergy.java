package cc3002.pokemon;


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
     * Add an energy to an abstracAttack
     * This is the handshake of the double dispatch
     *
     * @param abstractAttack the abstracAttack
     */
    void addInto(AbstractAttack abstractAttack);


    /**
     * Add an energy to an abstractPokemon
     * This is the handshake of the double dispatch
     *
     */
    void addToPoke();
}
