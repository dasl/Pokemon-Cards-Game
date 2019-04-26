package cc3002.pokemon;

import static org.junit.Assert.*;
import java.util.ArrayList;

import cc3002.pokemon.electric.ElectricPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.water.WaterAttack;
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
    private IAttack
            fireAttack,
            waterAttack,
            combolozicoAttack;
    private NormalEnergy normalEnergy;

    @Before
    public void setUp() {
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu", 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
        juanito = new Trainer(charmander,new ArrayList<>(),new ArrayList<>());
        Ash = new Trainer(audino,new ArrayList<>(),new ArrayList<>());
        waterAttack = new WaterAttack("Bubble", 50);
        fireAttack = new FireAttack("Ember", 40);
        combolozicoAttack = new NormalAttack("Combolozico", 70);
        charmander.setAttacks(fireAttack);
        charmander.setAttacks(combolozicoAttack);
        Ash.addPokemonToDeck(pikachu);
        Ash.addPokemonToDeck(totodile);
        Ash.addPokemonToDeck(charmander);
        Ash.setActivePokemon(charmander);


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
        combolozicoAttack.setNormalRequiredEnergies(normalEnergy);
        combolozicoAttack.setNormalRequiredEnergies(normalEnergy);
        combolozicoAttack.setNormalRequiredEnergies(normalEnergy);
        assertEquals(3,combolozicoAttack.getNormalRequiredEnergies());
        Ash.getActivePokemon().receiveNormalEnergy(normalEnergy);
        Ash.getActivePokemon().receiveNormalEnergy(normalEnergy);
        Ash.getActivePokemon().receiveNormalEnergy(normalEnergy);
        assertTrue(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon() ,combolozicoAttack));
    }

    @Test
    public void DeadActivePokemon(){
        assertEquals(Ash.getActivePokemon().getHP(),100);
        waterAttack.attack(Ash.getActivePokemon());
        assertEquals(Ash.getActivePokemon().getHP(),0);
        Ash.DeadPokemon(Ash.getActivePokemon());
        assertEquals("Pikachu", Ash.getActivePokemonName());
    }
}