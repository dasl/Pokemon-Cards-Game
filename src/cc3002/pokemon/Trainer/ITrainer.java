package cc3002.pokemon.Trainer;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.TrainerCards.StadiumCards.StadiumCard;

import java.util.List;

/**
 * Common interface implemented for all the trainer in the game.
 * This includes all the necessary methods to play as trainer.
 *
 * @author Diego Sandoval Leiva
 */

public interface ITrainer {

    void fromDeckToHand();

    void fromHandToBench();

    void lookAtTheScenario();

    void removefromDeck(ICard poke);

    void shuffleDeck();

    void addPokemonToBench(IPokemon pokemon);

    void addToCardsDeck(ICard card);

    void addToCardsHand(ICard card);

    void selectAbility(int index);

    void useAbility(Trainer adversary);

    void setActivePokemon(IPokemon pokemon);

    IPokemon getActivePokemon();

    List<ICard> getStadiumList();

    void setStadiumList(StadiumCard stadiumCard);

    void cleanStadiumList();

    void setPokemonType(IPokemon pokemon);

    void setOponent(AbstractTrainer trainer);

    AbstractTrainer getOponent();

    ICard getCard();

    void addToCementery(ICard card);

    void dropHand();


    void setSelectedPokemon(IPokemon pokemon);

    IPokemon getSelectedPokemon();

    boolean getDeadPokemon(IPokemon pokemon);

    void evolution(IPokemon pokemon);

    void changeFromBench(IPokemon pokemon);

    void intheritEnergies(IPokemon pokemon, IPokemon evolution);

    String getName();

    String getActivePokemonName();

    int sizePokeBench();

    int sizePokeDeck();

    int sizePokeHand();

    List<IPokemon> getBench();

    List<ICard> getDeck();

    void pokeToCementery(IPokemon pokemon);


    List<ICard> getHand();
}
