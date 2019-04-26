package cc3002.pokemon;

import java.util.List;

public class Trainer extends AbstractTrainer{

    private IPokemon ActivePoke;

    public Trainer(IPokemon ActivePoke, List<IPokemon> PokeDeckList, List<IPokemon> PokeStockList) {
        super(ActivePoke, PokeDeckList, PokeStockList);
    }



}
