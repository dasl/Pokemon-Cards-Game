package cc3002.pokemon.electric;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.AbstractEnergy;


/**
 * Class that represents a Electric type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class ElectricEnergy extends AbstractEnergy {
    private String NameType = "Electric";

    /**
     * Creates a new Electric Energy.
     *
     */
    public ElectricEnergy() { }

    @Override
    public String getEnergyNameType() {
        return this.NameType;
    }

    /**
     * Add an energy to an abilities
     * This is the handshake of the double dispatch
     *
     * @param abilities the abilities
     */
    @Override
    public void addInto(IAbilities abilities) {
       abilities.setElectricRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveElectricEnergy(this);
    }
}
