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
            getTrainer().fromDeckToHand();
            getTrainer().fromDeckToHand();
        }
        if(coinValue==1){
            getTrainer().fromDeckToHand();
            getTrainer().fromDeckToHand();
            getTrainer().fromDeckToHand();
        }
        getTrainer().addToCementery(this);
    }
}
