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
    private AbstractTrainerCard trainerCard;

    @Override
    public void visitPokemonCard(AbstractPokemon pokemonCard) { }

    @Override
    public void visitTrainerCard(AbstractTrainerCard trainerCard) {
        this.trainerCard = trainerCard;
    }

    @Override
    public void visitEnergyCard(AbstractEnergy energyCard) {

    }

    public void play(){
        this.trainerCard.play();
    }
}
