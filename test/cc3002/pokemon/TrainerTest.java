package cc3002.pokemon;

import static org.junit.Assert.*;
import java.util.ArrayList;

import cc3002.pokemon.electric.ElectricPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

public class TrainerTest {
    private IPokemon
            charmander,
            treecko,
            totodile,
            audino,
            pikachu;
    private Trainer
            juanito,
            Ash;

    @Before
    public void setUp() {
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu", 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
        juanito = new Trainer(charmander,new ArrayList<>(),new ArrayList<>());
        Ash = new Trainer(audino,new ArrayList<>(),new ArrayList<>());

    }


    @Test
    public void constructorTest() {
        assertEquals("Pikachu", Ash.getActivePokemon());

    }

    @Test
    public void changeActivePokeon(){
        assertEquals("Pikachu", Ash.getActivePokemon());
        assertEquals("Charmander", juanito.getActivePokemon());
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

//    @Test
//    public void ableToAtack(){
//        assertTrue(juanito.getActivePokemon().isBeAbleToAtack());
//
//    }

}