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
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu", 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
        juanito = new Trainer(charmander,new ArrayList<>());
        Ash = new Trainer(audino,new ArrayList<>());
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.");
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
        combolozicoAttack = new NormalAttack("Combolozico", 200,"The best attack of game, is lethal");

        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        electricEnergy = new ElectricEnergy();
        grassEnergy = new GrassEnergy();
        pyshicEnergy = new PsychicEnergy();
        normalEnergy = new NormalEnergy();

        // Addind attacks to the pokemon.
        charmander.setAttacks(fireAttack);
        charmander.setAttacks(combolozicoAttack);
        // Setting the pokedeck.
        Ash.setActivePokemon(charmander);
        Ash.addPokemonToDeck(pikachu);
        Ash.addPokemonToDeck(charmander);
        Ash.addPokemonToDeck(totodile);
        Ash.addPokemonToDeck(treecko);
        Ash.addPokemonToDeck(audino);

    }


    @Test
    public void constructorTest() {
        assertEquals("Charmander", Ash.getActivePokemonName());

    }

    @Test
    public void changeActivePokeon(){
        assertEquals("Charmander", Ash.getActivePokemonName());
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
    public void ableToAtack(){
        assertEquals("Charmander", Ash.getActivePokemonName());
        // Charging the energies requires into the attack.
        combolozicoAttack.receiveEnergy(normalEnergy);
        combolozicoAttack.receiveEnergy(normalEnergy);
        combolozicoAttack.receiveEnergy(normalEnergy);
        assertEquals(3,combolozicoAttack.getNormalRequiredEnergies());
        assertFalse(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
        // Charging the energies requires into the pokemon
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        Ash.getActivePokemon().receiveEnergy(normalEnergy);
        assertTrue(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
    }

    @Test
    public void DeadActivePokemon(){
        assertEquals(Ash.getActivePokemon().getHP(),100);
        waterAttack.attack(Ash.getActivePokemon());
        assertEquals(Ash.getActivePokemon().getHP(),0);
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Pikachu", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Charmander", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Totodile", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Treecko", Ash.getActivePokemonName());
        combolozicoAttack.attack(Ash.getActivePokemon());
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Audino", Ash.getActivePokemonName());
        // GG WP

    }
}