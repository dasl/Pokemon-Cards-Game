package cc3002.pokemon.electric;

import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.BasicNP;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Tests set for the ElectricPokemon class.
 *
 * @author Diego Sandoval Leiva
 */
public class ElectricPokemonTest {
    private Trainer Ash;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
    private IPokemon audino,pikachu,raichu,pichu;
    private FireAttack fireAttack;
    private GrassAttack grassAttack;
    private NormalAttack normalAttack;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private ElectricAttack electricAttack;


    @Before
    public void setUp() {
        psychicAttack = new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused.",new EnergyCounter());
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        grassAttack = new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines.",new EnergyCounter());
        normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter());
        waterAttack = new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
        electricAttack = new ElectricAttack("Thunder Shock",30,"An attack that may cause paralysis.",new EnergyCounter());
        audino = new BasicNP("Audino",1, 100, new ArrayList<>());


        pichu = new BasicEP("Pichu", 25,100,
                new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));
        pikachu = new Phase1EP("Pikachu", 25,100,
                new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));
        raichu = new Phase2EP("Raichu", 25,100,
                new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));


        //Creating Trainer
        Ash = new Trainer("Ash",pikachu,new ArrayList<>());


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
        normalEnergy = new NormalEnergy();
        normalEnergy.setTrainer(Ash);
    }




    @Test
    public void constructorTest() {
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(100, pikachu.getHP());
        assertEquals(2, pikachu.getAbilityList().size());
        assertEquals(electricAttack, pikachu.getAbilityList().get(0));
        assertEquals(normalAttack, pikachu.getAbilityList().get(1));
        assertNull(pikachu.getSelectedAbility());
        assertFalse(pichu.equals(raichu));
        assertFalse(raichu.equals(pikachu));
        assertFalse(pikachu.equals(pichu));
    }

    @Test
    public void evolutionTest(){
        Ash.addPokemonToBench(pikachu);
        Ash.setSelectedPokemon(pikachu); // Seleccionamos al pikachu
        Ash.evolution(raichu); // Pikachu -> raichu
        Ash.setSelectedPokemon(raichu); //Seleccionamos al raichu
        assertTrue(Ash.getBench().contains(raichu));
        assertFalse(Ash.getBench().contains(pikachu));
    }

    @Test
    public void cardType(){
        assertEquals("Pokemon",pikachu.getCardType());
    }

    @Test
    public void receiveEnergies(){
        Ash.setSelectedPokemon(pikachu);
        assertEquals(0, pikachu.getFireEnergies());
        Ash.getSelectedPokemon().receiveEnergy(fireEnergy);
        assertEquals(1, pikachu.getFireEnergies());
        Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
        Ash.getSelectedPokemon().receiveEnergy(waterEnergy);
        Ash.getSelectedPokemon().receiveEnergy(grassEnergy);
        assertEquals(1, pikachu.getFireEnergies());
        assertEquals(1, pikachu.getWaterEnergies());
        assertEquals(1, pikachu.getElectricEnergies());
        assertEquals(1, pikachu.getGrassEnergies());
    }

    @Test
    public void selectAttackTest() {
        pikachu.selectAbility(0);
        assertEquals(electricAttack, pikachu.getSelectedAbility());
        pikachu.selectAbility(1);
        assertEquals(normalAttack, pikachu.getSelectedAbility());
    }


    @Test
    public void receiveWaterAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveWaterAttack(waterAttack);
        assertEquals(60, pikachu.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveGrassAttack(grassAttack);
        assertEquals(55, pikachu.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveFireAttack(fireAttack);
        assertEquals(60, pikachu.getHP());
    }

    @Test
    public void receiveNormalAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveNormalAttack(normalAttack);
        assertEquals(20, pikachu.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveElectricAttack(electricAttack);
        assertEquals(70, pikachu.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receivePsychicAttack(psychicAttack);
        assertEquals(50, pikachu.getHP());
    }

}