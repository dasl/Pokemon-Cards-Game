package cc3002.pokemon.water;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.AbstractAttack;

/**
 * Class that represents a Water type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class WaterEnergy extends AbstractEnergy{
    private String NameType = "Water";

    /**
     * Creates a new Water Energy.
     *
     */
    public WaterEnergy() {

    }

    @Override
    public String getEnergyNameType() {
        return this.NameType;
    }

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setWaterRequiredEnergies(this);
    }

    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveWaterEnergy(this);
    }
}
