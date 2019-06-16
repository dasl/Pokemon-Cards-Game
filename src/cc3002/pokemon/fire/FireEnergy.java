package cc3002.pokemon.fire;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

/**
 * Class that represents a Fire type Energy.
 *
 * @author Diego Sandoval Leiva
 */
public class FireEnergy extends AbstractEnergy {
    private String NameType = "Fire";

    /**
     * Creates a new Fire Energy.
     *
     */
    public FireEnergy() { }

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
        abilities.setFireRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receiveFireEnergy(this);
    }

}
