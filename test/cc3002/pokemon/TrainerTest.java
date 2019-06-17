package cc3002.pokemon;

import static org.junit.Assert.*;
import java.util.ArrayList;

import cc3002.pokemon.Abilities.attacks.IAttack;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.BasicEP;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.electric.Phase1EP;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.Phase1FP;
import cc3002.pokemon.grass.BasicGP;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.BasicNP;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.BasicWP;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
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
            pikachu,
            raichu,
            charmeleon;

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
        treecko = new BasicGP("Treecko", 1,100, new ArrayList<>());
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>());
        audino = new BasicNP("Audino",1,100, new ArrayList<>());
        pikachu = new BasicEP("Pikachu",56,100, new ArrayList<>());
        charmeleon = new Phase1FP("Charmeleon",48,100, new ArrayList<>());
        raichu = new Phase1EP("Raichu",56,100, new ArrayList<>());

        // Creating attacks
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        combolozicoAttack = new NormalAttack("Combolozico", 200,"The best attack of game, is lethal",new EnergyCounter());

        // Creating trainers
        charmander = new BasicFP("Charmander", 48,100, new ArrayList<>());
        juanito = new Trainer("Juanoide",charmander,new ArrayList<>());
        charmander = new BasicFP("Charmander de Ash", 1,100, new ArrayList<>());
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
        charmander.setAbilities(fireAttack);
        charmeleon.setAbilities(fireAttack);
        charmander.setAbilities(combolozicoAttack);

        // Setting the pokedeck.
        Ash.setActivePokemon(charmander);
        Ash.addPokemonToBench(pikachu);
        Ash.addPokemonToBench(audino);
        Ash.addPokemonToBench(totodile);
        Ash.addPokemonToBench(treecko);
        Ash.addPokemonToBench(audino);

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
    public void evolutionTest(){
        Ash.setSelectedPokemon(pikachu); // Seleccionamos al pikachu
        Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
        Ash.getSelectedPokemon().receiveEnergy(pyshicEnergy);
        Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
        Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
        assertEquals(Ash.getSelectedPokemon().getElectricEnergies(),3);

        Ash.evolution(raichu); // Pikachu -> raichu
        Ash.setSelectedPokemon(raichu); //Seleccionamos al raichu
        assertTrue(Ash.getBench().contains(raichu));
        assertFalse(Ash.getBench().contains(pikachu));
        assertEquals(Ash.getSelectedPokemon().getElectricEnergies(),3);
    }

    @Test
    public void addingToBench(){
        juanito.addPokemonToBench(totodile);
        assertEquals(1,juanito.sizePokeBench());
        juanito.addPokemonToBench(audino);
        juanito.addPokemonToBench(treecko);
        assertEquals(3,juanito.sizePokeBench());
        juanito.addPokemonToBench(treecko);
        juanito.addPokemonToBench(treecko);
        assertEquals(5,juanito.sizePokeBench());
        // LIMIT CASE, MORE THAN FIVE POKEMONS IN THE DECK
        juanito.addPokemonToBench(treecko);
        assertEquals(5,juanito.sizePokeBench());
    }

    @Test
    public void adversaryDeck(){
        // Juanito vs Ash
        assertNotEquals(Ash.getBench(), juanito.getBench());
        // Active pokemon name is equal to the adversary active pokemon
        assertNotEquals(Ash.getActivePokemonName(), juanito.getActivePokemonName());
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
//        assertFalse(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
        // Charging the energies requires into the pokemon
        Ash.setSelectedPokemon(charmander);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        assertEquals(Ash.getActivePokemon().getNormalEnergies(),3);
//        assertTrue(Ash.pokeIsBeAbleToAtackWith(Ash.getActivePokemon(),combolozicoAttack));
    }

    @Test
    public void DeadActivePokemon(){
        Ash.setSelectedPokemon(charmander);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        assertEquals(Ash.getActivePokemon().getHP(),100);
        waterAttack.attack(Ash.getActivePokemon());
        assertEquals(Ash.getActivePokemon().getHP(),0);
        Ash.pokeToCementery(Ash.getActivePokemon());
        assertTrue(Ash.getDeadPokemon(charmander));
        // GG WP
    }



}