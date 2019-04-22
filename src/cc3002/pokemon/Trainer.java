package cc3002.pokemon;

import java.util.List;

public class Trainer extends AbstractTrainer {

    protected Trainer(ITrainer ActivePoke, List<ICards> PokeDeckList, List<ICards> PokeStockList) {
        super(ActivePoke, PokeDeckList, PokeStockList);
    }


}
