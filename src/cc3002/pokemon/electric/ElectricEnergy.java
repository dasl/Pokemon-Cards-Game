package cc3002.pokemon.electric;

import cc3002.pokemon.AbstractAttack;
import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IEnergy;


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
    public void addToPoke(AbstractPokemon abstractPokemon) {
        abstractPokemon.receiveElectricEnergy(this);
    }
}
