package cc3002.pokemon;

import java.util.List;
public abstract class AbstractTrainer implements ITrainer{

    private List<ICards> PokeStockList;
    private List<ICards> PokeDeckList;
    private ITrainer ActivePoke;

    protected AbstractTrainer(ITrainer ActivePoke, List<ICards> PokeDeckList, List<ICards> PokeStockList) {
        this.ActivePoke = ActivePoke;
        this.PokeDeckList = PokeDeckList;
        this.PokeStockList = PokeStockList;
    }


}
