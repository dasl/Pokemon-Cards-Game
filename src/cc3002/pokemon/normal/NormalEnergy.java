package cc3002.pokemon.normal;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class that represents a Normal type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class NormalEnergy extends AbstractEnergy {


    /**
     * Creates a new attack.
     *
     * @param energy Energy Type
     */
    protected NormalEnergy(IEnergy energy) {
        super(energy);
    }
}
