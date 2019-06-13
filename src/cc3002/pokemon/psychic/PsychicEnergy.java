package cc3002.pokemon.psychic;

import cc3002.pokemon.*;

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

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setPsychicRequiredEnergies(this);
    }

    @Override
    public void addToPoke() {
        getTrainer().getActivePokemon().receivePsychicEnergy(this);
    }
}
