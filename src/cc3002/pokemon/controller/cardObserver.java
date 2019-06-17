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
    ICard card;

    /**
     * cardObserver constructor.
     * setter of observable
     *
     */
    public cardObserver(){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ICard) {
            card = (ICard) obs;
        }
    }
}
