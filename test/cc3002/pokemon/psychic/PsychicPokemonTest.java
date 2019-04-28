package cc3002.pokemon.psychic;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicPokemon;
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
        charmander = new FirePokemon("Charmander",1, 100, new ArrayList<>());
        abra = new PsychicPokemon("Abra",1 ,100,
                new ArrayList<>(Arrays.asList(psychicAttack, normalAttack)));

        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        electricEnergy = new ElectricEnergy();
        grassEnergy = new GrassEnergy();
        psychicEnergy = new PsychicEnergy();
        normalEnergy = new NormalEnergy();
    }


    @Test
    public void cardType(){
        assertEquals("Pokemon",abra.getCardType());
    }

    @Test
    public void constructorTest() {
        assertEquals("Abra", abra.getName());
        assertEquals(100, abra.getHP());
        assertEquals(1, abra.getId());
        assertEquals(2, abra.getAttacks().size());
        assertEquals(psychicAttack, abra.getAttacks().get(0));
        assertEquals(normalAttack, abra.getAttacks().get(1));
        assertNull(abra.getSelectedAttack());
    }

    @Test
    public void receiveEnergies(){
        assertEquals(0, abra.getFireEnergies());
        abra.receiveEnergy(fireEnergy);
        assertEquals(1, abra.getFireEnergies());
        abra.receiveEnergy(electricEnergy);
        abra.receiveEnergy(waterEnergy);
        abra.receiveEnergy(grassEnergy);
        abra.receiveEnergy(normalEnergy);
        assertEquals(1, abra.getFireEnergies());
        assertEquals(1, abra.getNormalEnergies());
        assertEquals(1, abra.getElectricEnergies());
        assertEquals(1, abra.getGrassEnergies());
    }

    @Test
    public void selectAttackTest() {
        abra.selectAttack(0);
        assertEquals(psychicAttack, abra.getSelectedAttack());
        abra.selectAttack(1);
        assertEquals(normalAttack, abra.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        abra.selectAttack(0);
        abra.attack(charmander);
        assertEquals(50, charmander.getHP());
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