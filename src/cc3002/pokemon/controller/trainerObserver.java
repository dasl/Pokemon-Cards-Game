package cc3002.pokemon.controller;


import cc3002.pokemon.Trainer.ITrainer;
import cc3002.pokemon.Trainer.Trainer;

import java.util.Observable;
import java.util.Observer;

/**
 * trainerObserver logic controller class.
 *
 * @author Diego Sandoval Leiva
 */

public class trainerObserver implements Observer {
    Observable observable;
    private ITrainer trainer;

    /**
     * trainerObserver constructor.
     * setter of observable
     *
     */
    public trainerObserver(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ITrainer) {
            trainer = (ITrainer) obs;
        }
    }

    public void StealAndPut(){
        trainer.fromDeckToHand();
    }

    public void LookHisHandAndPlay(){
        trainer.fromHandToBench();
    }

    public void LookinTheScenario(){
        trainer.lookAtTheScenario();
    }

    public void useAbility(){
        trainer.useAbility((Trainer) trainer.getOponent());
    }


}
