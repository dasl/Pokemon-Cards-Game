package cc3002.pokemon.controller;

import java.util.Observable;
import java.util.Observer;

public interface ICardObserver extends Observer {
    @Override
    void update(Observable obs, Object arg);

    void stadiumCardInGame();
}
