package cc3002.pokemon.Trainer;

import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;

import java.util.List;

public interface ITrainer {

    void fromDeckToHand();

    void removefromDeck(ICard poke);

    void shuffleDeck();

    void addPokemonToBench(IPokemon pokemon);

    void addToCardsDeck(ICard card);

    void addToCardsHand(ICard card);

    void selectAbility(int index);

    void useAbility(Trainer adversary);

    void setActivePokemon(IPokemon pokemon);

    IPokemon getActivePokemon();

    void setPokemonType(IPokemon pokemon);

    void setOponent(AbstractTrainer trainer);

    AbstractTrainer getOponent();

    ICard getCard();

    void addToCementery(ICard card);

    void dropHand();

    void ShiftType();

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

    void AIAEffect();

    List<ICard> getHand();
}
