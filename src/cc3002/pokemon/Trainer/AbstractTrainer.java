package cc3002.pokemon.Trainer;


import cc3002.pokemon.ICard;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

/**
 * Abstract class that represents a generic Trainer. This class contains the necessary methods to
 * create a Pockedeck, an active pokemon, identify if a pokemon is dead or if a pokemon is able to attack.
 *
 * @author Diego Sandoval Leiva
 */

public abstract class AbstractTrainer extends Observable implements ITrainer{
    private List<IPokemon> bench;
    private List<ICard> hand;
    private List<ICard> Deck;
    private List<ICard> Cementery;
    private List<ICard> cardPrizes;
    private IPokemon selectedPokemon;
    private IPokemon ActivePoke;
    private IPokemon aux;
    private String name;
    private AbstractTrainer oponent;

    public void trainerChanges(){
        setChanged();
        notifyObservers();
    }

    /**
     * Creates a new Trainer.
     *
     * @param ActivePoke  Active Pokemon.
     * @param bench bench.

     */
    protected AbstractTrainer(String name, IPokemon ActivePoke, List<IPokemon> bench) {
        this.ActivePoke = ActivePoke;
        this.bench = bench;
        this.name = name;
        this.Deck =  new ArrayList<ICard>(60);
        this.Cementery =  new ArrayList<ICard>();
        this.cardPrizes = new ArrayList<ICard>(6);
        this.hand = new ArrayList<>(60);
    }


    /**
     * Take a card of pockedeck and put in the hand.
     *
     */
     @Override
     public void fromDeckToHand(){
         addToCardsHand(getCard());
         trainerChanges();
     }

    /**
     * Take a card of pockedeck and put in the hand.
     *
     */
    @Override
    public void removefromDeck(ICard poke){
        this.Deck.remove(poke);
        trainerChanges();
    }

    /**
     * Take a card of pockedeck and put in the hand.
     *
     */
    @Override
    public void shuffleDeck(){
        Collections.shuffle(this.Deck);
        trainerChanges();
    }



    /**
     * Add a new pokemon to the pokedeck.
     *
     * @param pokemon Active Pokemon.
     */
    @Override
    public void addPokemonToBench(IPokemon pokemon){
        if (bench.size()<5){
            this.bench.add(pokemon);
        }
        trainerChanges();
    }


    /**
     * Add a new card to the cardsdeck.
     *
     * @param card Active Pokemon.
     */
    @Override
    public void addToCardsDeck(ICard card){
        if (Deck.size()<60){
            this.Deck.add(card);
        }
    }

    /**
     * Add a new card to the cardsdeck.
     *
     * @param card Active Pokemon.
     */
    @Override
    public void addToCardsHand(ICard card){
        if (hand.size()<60){
            this.hand.add(card);
        }
    }


    /**
     * Select the ability of the Active Pokemon by index.
     *
     * @param index ability Pokemon.
     */
    @Override
    public void selectAbility(int index) {
        ActivePoke.selectAbility(index);
    }

    /**
     * Use an ability to attack the adversary trainer.
     *
     * @param adversary adversary.
     */
    @Override
    public void useAbility(Trainer adversary) {
        ActivePoke.useAbility(adversary);
    }


    /**
     * Setter of a pokemon to the Active Pokemon.
     *
     * @param pokemon Active Pokemon.
     */
    @Override
    public void setActivePokemon(IPokemon pokemon){
            this.ActivePoke = pokemon;
    }

    /**
     * Getter of a Active Pokemon.
     *
     */
    @Override
    public IPokemon getActivePokemon(){
        return this.ActivePoke;
    }



    /**
     * Getter type of any Pokemon.
     *
     */
    @Override
    public void setPokemonType(IPokemon pokemon){
        if(bench.contains(pokemon)){
            this.aux = pokemon;
        }
        else
            this.aux = getActivePokemon();
    }

    /**
     * Setter of oponent.
     *
     */
    @Override
    public void setOponent(AbstractTrainer trainer){
        this.oponent = trainer;
    }

    /**
     * Getter of oponent.
     *
     * @return oponent
     */
    @Override
    public AbstractTrainer getOponent(){
        return this.oponent;
    }

    /**
     * Getter of deck.
     *
     * @return card
     */
    @Override
    public ICard getCard(){
        ICard aux = Deck.get(0);
        Deck.remove(0);
        return aux;
    }


    /**
     * Add card to the cementery
     *
     * @param card Any card
     */
   @Override
    public void addToCementery(ICard card){
        ICard aux = card;
        this.Cementery.add(card);
        getHand().remove(getHand().indexOf(card));
        trainerChanges();
    }

    /**
     * Delete all the cards because of picado.
     *
     */
    @Override
    public void dropHand(){
        this.hand.clear();
    }



    /**
     * Setter type of any Pokemon.
     *
     */
    @Override
    public void ShiftType(){
        getActivePokemon().copyType(this.selectedPokemon, (Trainer) this);
        trainerChanges();
    }

    /**
     * Setter any Pokemon to selected.
     *
     * @return pokemon type
     */
    @Override
    public void setSelectedPokemon(IPokemon pokemon){
        this.selectedPokemon=pokemon;
    }

    /**
     * Getter any Pokemon to selected.
     *
     * @return pokemon type
     */
    @Override
    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }


    /**
     * Getter of dead pokemons in the cementery.
     *
     * @return dead pokemon
     */
    @Override
    public boolean getDeadPokemon(IPokemon pokemon){
        return Cementery.contains(pokemon);
    }


    /**
     * Evolution of any Pokemon from bench.
     *
     */
    @Override
    public void evolution(IPokemon pokemon){
        changeFromBench(pokemon);
        trainerChanges();
    }
    /**
     * Change any Pokemon from bench.
     *
     */
    @Override
    public void changeFromBench(IPokemon pokemon){
        for (IPokemon poke : bench){
            if (poke.getID()==pokemon.getID()){
                intheritEnergies(poke,pokemon);
                this.Cementery.add(poke);
                bench.set(bench.indexOf(poke),pokemon);
            }
        }
        trainerChanges();
    }

    /**
     *
     * inherit energies from another pokemon.
     *
     */
    @Override
    public void intheritEnergies(IPokemon pokemon, IPokemon evolution){
        int currentEE = pokemon.getElectricEnergies();
        int currentFE = pokemon.getFireEnergies();
        int currentPE = pokemon.getPsychicEnergies();
        int currentWE = pokemon.getWaterEnergies();
        int currentNE = pokemon.getNormalEnergies();
        int currentGE = pokemon.getGrassEnergies();

        while (0<currentEE){
            evolution.receiveElectricEnergy(new ElectricEnergy());
            currentEE--;
        }
        while (0<currentFE){
            evolution.receiveFireEnergy(new FireEnergy());
            currentFE--;
        }

        while (0<currentPE){
            evolution.receivePsychicEnergy(new PsychicEnergy());
            currentPE--;
        }
        while (0<currentWE){
            evolution.receiveWaterEnergy(new WaterEnergy());
            currentWE--;
        }
        while (0<currentNE){
            evolution.receiveNormalEnergy(new NormalEnergy());
            currentNE--;
        }
        while (0<currentGE){
            evolution.receiveGrassEnergy(new GrassEnergy());
            currentGE--;
        }
    }


    /**
     * Getter of  Active Trainer name's.
     *
     */
    @Override
    public String getName(){
        return this.name;
    }



    /**
     * Getter of  Active Pokemon name's.
     *
     */
    @Override
    public String getActivePokemonName(){
        return this.ActivePoke.getName();
    }


    /**
     * Getter of pockebench sizes.
     *
     */
    @Override
    public int sizePokeBench(){
        return this.bench.size();
    }

    /**
     * Getter of pockedeck sizes.
     *
     */
    @Override
    public int sizePokeDeck(){
        return this.Deck.size();
    }

    /**
     * Getter of pockehand sizes.
     *
     */
    @Override
    public int sizePokeHand(){
        return this.hand.size();
    }


    /**
     * Getter of bench.
     *
     */
    @Override
    public List<IPokemon> getBench(){
        return bench;
    }

    /**
     * Getter of pockedeck.
     *
     */
    @Override
    public List<ICard> getDeck(){
        return Deck;
    }




    /**
     * Changer of a dead pokemon to an alive one.
     *
     * @param pokemon Active Pokemon.
     */
    @Override
    public void pokeToCementery(IPokemon pokemon){
        if (pokemon.getHP()<=0){
            pokemon.resetEnergies();
            this.Cementery.add(pokemon);
            this.ActivePoke= bench.get(0);
            this.bench.remove(0);
        }
        trainerChanges();
    }

    /**
     *
     * Search your deck for up to 2 Pokemon of the same species as the one
     * use this ability and place them on the bench, then roll the deck..
     *
     */
    @Override
    public void AIAEffect(){
        int max = 2;
        for (ICard poke : this.Deck){
            if(getActivePokemon().equals(poke) && max>0){
                addPokemonToBench((IPokemon)poke);
                removefromDeck(poke);
                max--;
            }
        }
        shuffleDeck();
        this.getActivePokemon().attack(getOponent().getActivePokemon());
        trainerChanges();
    }


    /**
     * Getter of hand
     *
     */
    @Override
    public List<ICard> getHand() {
        return this.hand;
    }
}
