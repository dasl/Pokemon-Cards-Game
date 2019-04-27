package cc3002.pokemon;


import cc3002.pokemon.fire.FireAttack;

/**
 * This function is performed through an interface, whose main function is to act as an intermediary to implement a double disptach, such that they can be
 * apply the energies required for an attack, as well as the energies
 * added for a certain pokemon.
 *
 * @author Diego Sandoval Leiva
 */

public interface IEnergy extends ICard{
    String getEnergyNameType();

    void addInto(AbstractAttack abstractAttack);

    void addToPoke(AbstractPokemon abstractPokemon);
}
