package cc3002.pokemon.controller;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.ICard;

import java.util.Observable;
import java.util.Observer;

/**
 * abilityObserver logic controller class.
 *
 * @author Diego Sandoval Leiva
 */

public class abilityObserver  implements Observer{
    Observable observable;
    IAbilities abilities;

    /**
     * abilityObserver constructor.
     * setter of observable
     *
     */

    public abilityObserver(){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ICard) {
            abilities = (IAbilities) obs;
        }
    }



}
