package cc3002.pokemon.TrainerCards.SupportCards;

/**
 * This class represents a Professor Juniper support card.
 *
 * @author Diego Sandoval Leiva
 */

public class ProfessorJuniper extends SupportCard{
    public ProfessorJuniper(String name, String text) {
        super(name, text);
    }

    @Override
    public void play(){
        getTrainer().dropHand();
        int aux = 7;
        while (aux>0){
            getTrainer().fromDeckToHand();
            aux--;
        }
    }
}
