package cc3002.pokemon.CardVisitor;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;


/**
 * Common interface for all the card's visitor.
 *
 * @author Diego Sandoval Leiva
 */


public interface ICardVisitor {
    /**
     * Pokemon card's visitor.
     *
     */
    void visitPokemonCard(AbstractPokemon pokemonCard);


    /**
     * Trainer card's visitor.
     *
     */
    void visitTrainerCard(AbstractTrainerCard trainerCard);

    /**
     * Energy card's visitor.
     *
     */
    void visitEnergyCard(AbstractEnergy energyCard);

}
