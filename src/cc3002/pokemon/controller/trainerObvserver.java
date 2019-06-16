package cc3002.pokemon.controller;

import cc3002.pokemon.Trainer.ITrainer;
import java.util.Observable;
import java.util.Observer;

public class trainerObvserver implements Observer {
    Observable observable;
    private ITrainer trainer;

    public trainerObvserver(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ITrainer) {
            trainer = (ITrainer) obs;
        }
    }
}
