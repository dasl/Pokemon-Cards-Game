package cc3002.pokemon.Abilities.otherAbilities;


import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.Trainer.Trainer;

import java.util.Random;

/**
 * Heal contains the required methods to use this ability.
 * Assuming that a typical pokemon have 100HP at an initial point.
 *
 * @author Diego Sandoval Leiva
 */

public class Heal extends AbstractAbilities {
    private Random coin = new Random();


    public Heal(String name, String text, EnergyCounter costs) {
        super(name, text, costs);
    }

    @Override
    public void applyEffect(Trainer trainer){
        int coinValue = coin.nextInt(2);
        if(coinValue==1){
            trainer.getOponent().getSelectedPokemon().resetHP();
        }
    }

}
