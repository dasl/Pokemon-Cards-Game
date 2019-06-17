package cc3002.pokemon.controller;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.TrainerCards.StadiumCards.StadiumCard;


import java.util.Observable;
import java.util.Observer;


/**
 * cardObserver logic controller class.
 *
 * @author Diego Sandoval Leiva
 */

public class cardObserver implements ICardObserver {
    Observable observable;
    private ICard card;


    /**
     * cardObserver constructor.
     * setter of observable
     *
     */
    public cardObserver(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ICard) {
            card = (ICard) obs;
        }
    }

    @Override
    public void stadiumCardInGame(){
        card.setStadiumCard();
    }



}
