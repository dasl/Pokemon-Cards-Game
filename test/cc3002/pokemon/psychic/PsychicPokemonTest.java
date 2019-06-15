package cc3002.pokemon.psychic;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the PsychicPokemon class.
 *
 * @author Diego Sandoval Leiva
 */

public class PsychicPokemonTest {
    private Trainer Ash;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
    private IPokemon
            charmander,
            abra;
    private FireAttack fireAttack;
    private GrassAttack grassAttack;
    private NormalAttack normalAttack;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private ElectricAttack electricAttack;

    @Before
    public void setUp() {
        psychicAttack = new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused.");
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
        grassAttack = new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines.");
        normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.");
        waterAttack = new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed.");
        electricAttack = new ElectricAttack("Thunder Shock",30,"An attack that may cause paralysis.");
        charmander = new BasicFP("Charmander", 1,100, new ArrayList<>());
        abra = new BasicPP("Abra",1,100,
                new ArrayList<>(Arrays.asList(psychicAttack, normalAttack)));

        //Creating Trainer
        Ash = new Trainer("Ash",abra,new ArrayList<>());

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
    public void cardType(){
        assertEquals("Pokemon",abra.getCardType());
    }

    @Test
    public void constructorTest() {
        assertEquals("Abra", abra.getName());
        assertEquals(100, abra.getHP());
        assertEquals(2, abra.getAbilityList().size());
        assertEquals(psychicAttack, abra.getAbilityList().get(0));
        assertEquals(normalAttack, abra.getAbilityList().get(1));
        assertNull(abra.getSelectedAbility());
    }

    @Test
    public void receiveEnergies(){
        Ash.setSelectedPokemon(abra);
        assertEquals(0, abra.getFireEnergies());
        Ash.getSelectedPokemon().receiveEnergy(fireEnergy);
        assertEquals(1, abra.getFireEnergies());
        Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
        Ash.getSelectedPokemon().receiveEnergy(waterEnergy);
        Ash.getSelectedPokemon().receiveEnergy(grassEnergy);
        Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
        assertEquals(1, abra.getFireEnergies());
        assertEquals(1, abra.getNormalEnergies());
        assertEquals(1, abra.getElectricEnergies());
        assertEquals(1, abra.getGrassEnergies());
    }

    @Test
    public void selectAttackTest() {
        abra.selectAbility(0);
        assertEquals(psychicAttack, abra.getSelectedAbility());
        abra.selectAbility(1);
        assertEquals(normalAttack, abra.getSelectedAbility());
    }


    @Test
    public void receiveWaterAttack() {
        assertEquals(100,abra.getHP());
        abra.receiveWaterAttack(waterAttack);
        assertEquals(60, abra.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveGrassAttack(grassAttack);
        assertEquals(55, abra.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveFireAttack(fireAttack);
        assertEquals(60, abra.getHP());
    }

    @Test
    public void receiveNormalAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveNormalAttack(normalAttack);
        assertEquals(90, abra.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveElectricAttack(electricAttack);
        assertEquals(70, abra.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, abra.getHP());
        abra.receivePsychicAttack(psychicAttack);
        assertEquals(0, abra.getHP());
    }

}