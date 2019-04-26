package cc3002.pokemon.psychic;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class that represents a Psychic type Energy.
 *
 * @author Diego Sandoval Leiva
 */

public class PsychicEnergy extends AbstractEnergy{

    /**
     * Creates a new attack.
     *
     * @param energy Energy Type
     */
    protected PsychicEnergy(IEnergy energy) {
        super(energy);
    }
}
