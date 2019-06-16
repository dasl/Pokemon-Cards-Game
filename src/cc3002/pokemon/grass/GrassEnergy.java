package cc3002.pokemon.grass;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

/**
 * Class that represents a Grass type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class GrassEnergy extends AbstractEnergy{
    private String NameType = "Grass";

    /**
     * Creates a new Grass Energy.
     *
     */
    public GrassEnergy() { }

    @Override
    public String getEnergyNameType() {
        return this.NameType;
    }

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setGrassRequiredEnergies(this);
    }

    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveGrassEnergy(this);
    }
}
