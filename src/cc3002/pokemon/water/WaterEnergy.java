package cc3002.pokemon.water;

import cc3002.pokemon.*;

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
    public WaterEnergy() { }

    @Override
    public String getEnergyNameType() {
        return this.NameType;
    }

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setWaterRequiredEnergies(this);
    }

    @Override
    public void addToPoke(AbstractPokemon abstractPokemon) {
        abstractPokemon.receiveWaterEnergy(this);
    }
}
