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

public class cardObserver implements Observer{
    Observable observable;
    private ICard card;
    private StadiumCard stadiumCard;
    private IPokemon pokemon;

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

    public void stadiumCardInGame(){
        this.stadiumCard = card.getStadiumCard();
    }



}
