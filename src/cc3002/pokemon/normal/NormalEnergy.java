package cc3002.pokemon.normal;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

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

    /**
     * Add an energy to an abilities
     * This is the handshake of the double dispatch
     *
     * @param abilities the abilities
     */
    @Override
    public void addInto(IAbilities abilities) {
        abilities.setNormalRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveNormalEnergy(this);
    }
}
