package cc3002.pokemon.grass;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.IAbilities;
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

    /**
     * Add an energy to an abilities
     * This is the handshake of the double dispatch
     *
     * @param abilities the abilities
     */
    @Override
    public void addInto(IAbilities abilities) {
        abilities.setGrassRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveGrassEnergy(this);
    }
}
