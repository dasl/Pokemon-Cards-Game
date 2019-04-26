package cc3002.pokemon.grass;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class that represents a Grass type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class GrassEnergy extends AbstractEnergy{

    /**
     * Creates a new attack.
     *
     * @param energy Energy Type
     */
    protected GrassEnergy(IEnergy energy) {
        super(energy);
    }
}
