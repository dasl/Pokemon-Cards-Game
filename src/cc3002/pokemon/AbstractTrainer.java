package cc3002.pokemon;

import java.util.List;
public abstract class AbstractTrainer implements ITrainer{

    private List<IPokemon> PokeStockList;
    private List<IPokemon> PokeDeck;
    private IPokemon ActivePoke;

    protected AbstractTrainer(IPokemon ActivePoke, List<IPokemon> pokeDeck, List<IPokemon> PokeStockList) {
        this.ActivePoke = ActivePoke;
        this.PokeDeck = pokeDeck;
        this.PokeStockList = PokeStockList;
    }

    public void addPokemonToDeck(IPokemon pokemon){
        if (PokeDeck.size()<5){
            this.PokeDeck.add(pokemon);
        }
    }

    public void addActivePokemon(IPokemon pokemon){
        this.ActivePoke=pokemon;
    }

    public String getActivePokemon(){
        return this.ActivePoke.getName();
    }

    public int sizePokeDeck(){
        return this.PokeDeck.size();
    }
}
