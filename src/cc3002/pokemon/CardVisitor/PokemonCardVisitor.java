package cc3002.pokemon.CardVisitor;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

/**
 * Visitor of PokemonCard
 *
 * @author Diego Sandoval Leiva
 */

public class PokemonCardVisitor implements ICardVisitor {
    private AbstractPokemon pokemonCard;

    @Override
    public void visitPokemonCard(AbstractPokemon pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    @Override
    public void visitTrainerCard(AbstractTrainerCard trainerCard) {

    }

    @Override
    public void visitEnergyCard(AbstractEnergy energyCard) {

    }

    public void play(){
        this.pokemonCard.play();
    }
}
