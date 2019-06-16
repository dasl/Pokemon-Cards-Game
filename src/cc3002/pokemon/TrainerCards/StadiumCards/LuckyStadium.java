package cc3002.pokemon.TrainerCards.StadiumCards;

import java.util.Random;

public class LuckyStadium extends StaduimCard {
    private Random coin = new Random();

    public LuckyStadium(String name, String text) {
        super(name, text);
    }
    @Override
    public void play() {
        int coinValue = coin.nextInt(2);
        if(coinValue==1){
            getTrainer().getCard();
        }
    }

}
