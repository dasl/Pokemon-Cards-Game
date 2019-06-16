package cc3002.pokemon.controller;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.ICard;

import java.util.Observable;
import java.util.Observer;

public class abilityObserver implements Observer {

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof IAbilities) {
            IAbilities abilities = (IAbilities) obs;

        }
    }
}
