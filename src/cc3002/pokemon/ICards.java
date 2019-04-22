package cc3002.pokemon;

public interface ICards {
    void playCard(ICards carta);
    void playPokemonCard(IPokemon pokemon);
    void playEnergyCard(IEnergy energy);
}
