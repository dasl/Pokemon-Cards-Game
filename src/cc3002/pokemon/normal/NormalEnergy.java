package cc3002.pokemon.normal;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.AbstractAttack;

/**
 * Class that represents a Normal type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class NormalEnergy extends AbstractEnergy {
    private String NameType = "Normal";

    /**
     * Creates a new Normal Energy.
     *
     */
    public NormalEnergy() { }

    @Override
    public String getEnergyNameType() {
        return this.NameType;
    }

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setNormalRequiredEnergies(this);
    }

    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveNormalEnergy(this);
    }
}
