package cc3002.pokemon.water;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

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

    /**
     * Add an energy to an abilities
     * This is the handshake of the double dispatch
     *
     * @param abilities the abilities
     */
    @Override
    public void addInto(IAbilities abilities) {
        abilities.setWaterRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveWaterEnergy(this);
    }
}
