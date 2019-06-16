package cc3002.pokemon.Abilities.otherAbilities;


import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.Trainer.Trainer;

public class Shift extends AbstractAbilities {


    public Shift(String name, String text, EnergyCounter costs) {
        super(name, text, costs);
    }

    @Override
    public void applyEffect(Trainer trainer){
        trainer.getActivePokemon().receiveShiftEffect(trainer);
    }

}
