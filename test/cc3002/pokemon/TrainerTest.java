package cc3002.pokemon;

import static org.junit.Assert.*;
import java.util.ArrayList;

import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.electric.ElectricPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the Trainer class.
 *
 * @author Diego Sandoval Leiva
 */

public class TrainerTest {
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
    private IPokemon
            charmander,
            charmanderjuanito,
             treecko,
            totodile,
            audino,
            pikachu;
    private Trainer
            juanito,
            Ash;
    private IAttack
            fireAttack,
            waterAttack,
            combolozicoAttack;

    @Before
    public void setUp() {
        // Creating pokemons
        ;
        treecko = new GrassPokemon("Treecko", 1,100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 1,100, new ArrayList<>());
        audino = new NormalPokemon("Audino",1,100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu",1,100, new ArrayList<>());

        // Creating attacks
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.");
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
        combolozicoAttack = new NormalAttack("Combolozico", 200,"The best attack of game, is lethal");

        // Creating trainers
        charmander = new FirePokemon("Charmander", 1,100, new ArrayList<>());
        juanito = new Trainer("Juanoide",charmander,new ArrayList<>());
        charmander = new FirePokemon("Charmander de Ash", 1,100, new ArrayList<>());
        Ash = new Trainer("Ash",charmander,new ArrayList<>());

        // Creating energies Cards
        // Las cartas deben poder ser jugadas por el entrenador que la tenga
        waterEnergy = new WaterEnergy();
        waterEnergy.setTrainer(Ash);
        fireEnergy = new FireEnergy();
        fireEnergy.setTrainer(Ash);
        electricEnergy = new ElectricEnergy();
        electricEnergy.setTrainer(Ash);
        grassEnergy = new GrassEnergy();
        grassEnergy.setTrainer(Ash);
        pyshicEnergy = new PsychicEnergy();
        pyshicEnergy.setTrainer(Ash);
        normalEnergy = new NormalEnergy();
        normalEnergy.setTrainer(Ash);

        // Adding attacks to the pokemon.
        charmander.setAttacks(fireAttack);
        charmander.setAttacks(combolozicoAttack);

        // Setting the pokedeck.
        Ash.setActivePokemon(charmander);
        Ash.addPokemonToDeck(pikachu);
        Ash.addPokemonToDeck(audino);
        Ash.addPokemonToDeck(totodile);
        Ash.addPokemonToDeck(treecko);
        Ash.addPokemonToDeck(audino);

    }


    @Test
    public void constructorTest() {
        assertEquals("Juanoide",juanito.getName());
        assertEquals("Charmander de Ash", Ash.getActivePokemonName());

    }

    @Test
    public void changeActivePokeon(){
        assertEquals("Charmander de Ash", Ash.getActivePokemonName());
        assertEquals("Charmander", juanito.getActivePokemonName());
    }


    @Test
    public void addingToDeck(){
        juanito.addPokemonToDeck(totodile);
        assertEquals(1,juanito.sizePokeDeck());
        juanito.addPokemonToDeck(audino);
        juanito.addPokemonToDeck(treecko);
        assertEquals(3,juanito.sizePokeDeck());
        juanito.addPokemonToDeck(treecko);
        juanito.addPokemonToDeck(treecko);
        assertEquals(5,juanito.sizePokeDeck());
        // LIMIT CASE, MORE THAN FIVE POKEMONS IN THE DECK
        juanito.addPokemonToDeck(treecko);
        assertEquals(5,juanito.sizePokeDeck());
    }

    @Test
    public void adversaryDeck(){
        // Juanito vs Ash
        assertFalse(Ash.getPokeDeck().equals(juanito.getPokeDeck()));
        // Active pokemon name is equal to the adversary active pokemon
        assertFalse(Ash.getActivePokemonName().equals(juanito.getActivePokemonName()));
        // Active pokemon is not equal to the adversary active pokemon
        Ash.setActivePokemon(charmander);
        juanito.setActivePokemon(charmander);
        assertEquals(Ash.getActivePokemon(),juanito.getActivePokemon());

    }

    @Test
    public void ableToAtack(){
        assertEquals("Charmander de Ash", Ash.getActivePokemonName());
        // Charging the energies requires into the attack.
        combolozicoAttack.receiveRequiredEnergy(normalEnergy);
        combolozicoAttack.receiveRequiredEnergy(normalEnergy);
        combolozicoAttack.receiveRequiredEnergy(normalEnergy);
        assertEquals(3,combolozicoAttack.getNormalRequiredEnergies());
        assertFalse(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
        // Charging the energies requires into the pokemon
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        assertEquals(Ash.getActivePokemon().getNormalEnergies(),3);
        assertTrue(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
    }

    @Test
    public void DeadActivePokemon(){
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        assertEquals(Ash.getActivePokemon().getHP(),100);
        waterAttack.attack(Ash.getActivePokemon());
        assertEquals(Ash.getActivePokemon().getHP(),0);
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertEquals("Pikachu", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertEquals("Audino", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertEquals("Totodile", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertEquals("Treecko", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertEquals("Audino", Ash.getActivePokemonName());
        // GG WP

    }
}