package cc3002.pokemon.TrainerCards.StadiumCards;

import java.util.Random;

/**
 * This class represents a LuckyStadium stadium card.
 *
 * @author Diego Sandoval Leiva
 */

public class LuckyStadium extends StadiumCard {
    private Random coin = new Random();

    public LuckyStadium(String name, String text) {
        super(name, text);
    }
    @Override
    public void play() {
        int coinValue = coin.nextInt(2);
        if(coinValue==1){
            getTrainer().fromDeckToHand();
        }
        setStadiumCard();
    }

}
