package cc3002.pokemon.fire;

import cc3002.pokemon.*;

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

    @Override
    public void addInto(AbstractAttack abstractAttack) {
        abstractAttack.setFireRequiredEnergies(this);
    }
    @Override
    public void addToPoke() {
        getTrainer().getActivePokemon().receiveFireEnergy(this);
    }

}
