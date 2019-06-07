package cc3002.pokemon;

/**
 * Common interface implemented by the two types of cards in the game, energies
 * and pokemons.
 *
 * @author Diego Sandoval Leiva
 */

public interface ICard {
    /**
     * Get the card type
     * If is an energy or a pokemon
     *
     */
    String getCardType();
    void play();
    void setTrainer(AbstractTrainer abstractTrainer);
}
