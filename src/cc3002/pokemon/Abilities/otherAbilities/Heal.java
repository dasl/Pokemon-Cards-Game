package cc3002.pokemon.Abilities.otherAbilities;


import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.Trainer.Trainer;

/**
 * Heal contains the required methods to use this ability.
 *
 * @author Diego Sandoval Leiva
 */

public class Heal extends AbstractAbilities {


    public Heal(String name, String text, EnergyCounter costs) {
        super(name, text, costs);
    }

    @Override
    public void applyEffect(Trainer trainer){
        trainer.getActivePokemon();
    }

}
