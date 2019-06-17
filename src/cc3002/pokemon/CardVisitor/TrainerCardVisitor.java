package cc3002.pokemon.CardVisitor;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

/**
 * Visitor of TrainerCard
 *
 * @author Diego Sandoval Leiva
 */

public class TrainerCardVisitor implements ICardVisitor {


    /**
     * Pokemon card's visitor.
     *
     * @param pokemonCard
     */
    @Override
    public void visitPokemonCard(AbstractPokemon pokemonCard) {

    }

    /**
     * Trainer card's visitor.
     *
     * @param trainerCard
     */
    @Override
    public void visitTrainerCard(AbstractTrainerCard trainerCard) {

    }

    /**
     * Energy card's visitor.
     *
     * @param energyCard
     */
    @Override
    public void visitEnergyCard(AbstractEnergy energyCard) {

    }
}
