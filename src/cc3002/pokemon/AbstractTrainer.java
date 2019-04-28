package cc3002.pokemon;


import java.util.List;

/**
 * Abstract class that represents a generic Trainer. This class contains the necessary methods to
 * create a Pockedeck, an active pokemon, identify if a pokemon is dead or if a pokemon is able to attack.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractTrainer{


    private List<IPokemon> PokeDeck;
    private IPokemon ActivePoke;
    private String name;


    /**
     * Creates a new Trainer.
     *
     * @param ActivePoke  Active Pokemon.
     * @param pokeDeck PokeDeck.

     */

    protected AbstractTrainer(String name, IPokemon ActivePoke, List<IPokemon> pokeDeck) {
        this.ActivePoke = ActivePoke;
        this.PokeDeck = pokeDeck;
        this.name = name;
    }


    /**
     * Add a new pokemon to the pokedeck.
     *
     * @param pokemon Active Pokemon.
     */

    public void addPokemonToDeck(IPokemon pokemon){
        if (PokeDeck.size()<5){
            this.PokeDeck.add(pokemon);
        }
    }

    /**
     * Setter of a pokemon to the Active Pokemon.
     *
     * @param pokemon Active Pokemon.
     */
    public void setActivePokemon(IPokemon pokemon){
            this.ActivePoke = pokemon;
    }

    /**
     * Getter of a Active Pokemon.
     *
     */

    public IPokemon getActivePokemon(){
        return this.ActivePoke;
    }


    /**
     * Getter of  Active Trainer name's.
     *
     */
    public String getName(){
        return this.name;
    }


    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */



    /**
     * Getter of  Active Pokemon name's.
     *
     */
    public String getActivePokemonName(){
        return this.ActivePoke.getName();
    }


    /**
     * Getter of pockedeck sizes.
     *
     */
    public int sizePokeDeck(){
        return this.PokeDeck.size();
    }


    /**
     * Getter of pockedeck.
     *
     */
    public List<IPokemon> getPokeDeck(){
        return PokeDeck;
    }
    /**
     * Checker of a pokemon and Attack.
     * Check if a pokemon is able to us an specific attack
     *
     * @param pokemon Active Pokemon.
     * @param ActiveAttack Active Attack.
     */

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


    /**
     * Changer of a dead pokemon to an alive one.
     *
     * @param pokemon Active Pokemon.
     */
    public void DeadPokemon(IPokemon pokemon){
        if (pokemon.getHP()<=0){
            this.ActivePoke=PokeDeck.get(0);
            this.PokeDeck.remove(0);
        }
    }
}
