package cc3002.pokemon;


import java.util.List;
public abstract class AbstractTrainer{

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


    public void setActivePokemon(IPokemon pokemon){
        if(PokeDeck.contains(pokemon)){
            this.ActivePoke = pokemon;
        }
    }

    public IPokemon getActivePokemon()  {
        return this.ActivePoke;
    }

    public String getActivePokemonName(){
        return this.ActivePoke.getName();
    }

    public int sizePokeDeck(){
        return this.PokeDeck.size();
    }

    public boolean pokeIsBeAbleToAtackWith (IPokemon pokemon, IAttack ActiveAttack){
        boolean couldBeActived = false;
        int currentlyFireEnergies = pokemon.getFireEnergies();
        int currentlyWaterEnergies = pokemon.getWaterEnergies();
        int currentlyElectricEnergies = pokemon.getElectricEnergies();
        int currentlyPsychicEnergies = pokemon.getPsychicEnergies();
        int currentlyNormalEnergies = pokemon.getNormalEnergies();
        int currentlyGrassEnergies = pokemon.getGrassEnergies();

        for(IAttack attacke : pokemon.getAttackList())
        {
            if(ActiveAttack.getName().equals(attacke.getName())){
                if (attacke.getFireRequiredEnergies()<= currentlyFireEnergies
                        && attacke.getElectricRequiredEnergies()<= currentlyElectricEnergies
                        && attacke.getGrassRequiredEnergies() <= currentlyGrassEnergies
                        && attacke.getNormalRequiredEnergies() <= currentlyNormalEnergies
                        && attacke.getPsychicRequiredEnergies() <= currentlyPsychicEnergies
                        && attacke.getWaterRequiredEnergies() <= currentlyWaterEnergies) {
                    couldBeActived = true;
                }
                else {
                    couldBeActived = false;
                }

            }
        }
        return  couldBeActived;
    }

    public void DeadPokemon(IPokemon pokemon){
        if (pokemon.getHP()<=0){
            this.ActivePoke=PokeDeck.get(0);
            this.PokeDeck.remove(0);
        }
    }
}
