package cc3002.pokemon.CardVisitor;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;

public class EnergyCardVisitor implements ICardVisitor {
    private AbstractEnergy energyCard;

    @Override
    public void visitPokemonCard(AbstractPokemon pokemonCard) {

    }

    @Override
    public void visitTrainerCard(AbstractTrainerCard trainerCard) {

    }

    @Override
    public void visitEnergyCard(AbstractEnergy energyCard) {
        this.energyCard = energyCard;
    }

    public void play(){
        this.energyCard.play();
    }
}
