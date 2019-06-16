package cc3002.pokemon.TrainerCards.SupportCards;

import java.util.Random;

public class ProfessorCozmosDiscovery extends SupportCard {
    private Random coin = new Random();


    public ProfessorCozmosDiscovery(String name, String text) {
        super(name, text);
    }

    @Override
    public void play() {
        int coinValue = coin.nextInt(2);
        if(coinValue==0){
            getTrainer().addToCardsHand(getTrainer().getCard());
            getTrainer().addToCardsHand(getTrainer().getCard());
        }
        if(coinValue==1){
            getTrainer().addToCardsHand(getTrainer().getCard());
            getTrainer().addToCardsHand(getTrainer().getCard());
            getTrainer().addToCardsHand(getTrainer().getCard());
        }
        getTrainer().addToCementery(this);
    }
}
