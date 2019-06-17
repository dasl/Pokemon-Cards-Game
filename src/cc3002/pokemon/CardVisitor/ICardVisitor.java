package cc3002.pokemon.CardVisitor;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;


/**
 * Common interface for all the card's visitor.
 *
 * @author Diego Sandoval Leiva
 */


public interface ICardVisitor {
    void visitPokemonCard(AbstractPokemon pokemonCard);
    void visitTrainerCard(AbstractTrainerCard trainerCard);
    void visitEnergyCard(AbstractEnergy energyCard);
}
