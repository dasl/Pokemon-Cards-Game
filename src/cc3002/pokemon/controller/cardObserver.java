package cc3002.pokemon.controller;

import cc3002.pokemon.ICard;
import cc3002.pokemon.Trainer.Trainer;

import java.util.Observable;
import java.util.Observer;


/**
 * cardObserver logic controller class.
 *
 * @author Diego Sandoval Leiva
 */

public class cardObserver implements Observer{
    Observable observable;
    Trainer trainer, oponentTrainer;


    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ICard) {
            ICard cartas = (ICard) obs;

        }
    }
}
