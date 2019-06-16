package cc3002.pokemon.psychic;

import cc3002.pokemon.*;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;

/**
 * Class that represents a Psychic type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class PsychicEnergy extends AbstractEnergy{
    private String NameType = "Psychic";
    /**
     * Creates a new attack.
     *

     */
    public PsychicEnergy() { }

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
        abilities.setPsychicRequiredEnergies(this);
    }


    @Override
    public void addToPoke() {
        getTrainer().getSelectedPokemon().receivePsychicEnergy(this);
    }
}
