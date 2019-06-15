package cc3002.pokemon.Abilities;


import cc3002.pokemon.Trainer.Trainer;

public class Shift extends AbstractAbilities {

    public Shift(String name, String text) {
        super(name, text);
    }


    @Override
    public void applyEffect(Trainer trainer){
        trainer.getActivePokemon().receiveShiftEffect(trainer);
    }

}
