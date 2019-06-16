package cc3002.pokemon.electric;

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

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setElectricRequiredEnergies(this);
    }

    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveElectricEnergy(this);
    }
}
