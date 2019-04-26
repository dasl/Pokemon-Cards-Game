package cc3002.pokemon;

import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;

import java.util.List;
public abstract class AbstractTrainer implements IActivePokemon{

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

    public void setActivePokemon(IPokemon pokemon){
        if(PokeDeck.contains(pokemon)){
            this.ActivePoke = pokemon;
        }
    }

    public String getActivePokemon(){
        return this.ActivePoke.getName();
    }

    public int sizePokeDeck(){
        return this.PokeDeck.size();
    }



}
