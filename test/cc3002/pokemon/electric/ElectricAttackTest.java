package cc3002.pokemon.electric;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests set for the ElectricAttack class.
 *
 * @author Diego Sandoval Leiva
 */

public class ElectricAttackTest {
    private IAttack electricAttack;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
    private IPokemon
            slowpoke,
            mew,
            kadabra,
            abra,
            charmander,
            pikachu,
            treecko,
            totodile,
            audino;

    @Before
    public void setUp(){
        electricAttack = new ElectricAttack("Thunder Shock",30,"An attack that may cause paralysis.");
        charmander = new FirePokemon("Charmander",1, 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko",1, 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile",1, 100, new ArrayList<>());
        audino = new NormalPokemon("Audino",1, 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu",1,100, new ArrayList<>());
        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        electricEnergy = new ElectricEnergy();
        grassEnergy = new GrassEnergy();
        pyshicEnergy = new PsychicEnergy();
        normalEnergy = new NormalEnergy();


    }

    @Test
    public void constructorTest() {
        assertEquals("Thunder Shock", electricAttack.getName());
        assertEquals(30, electricAttack.getBaseDamage());
        assertEquals("An attack that may cause paralysis.", electricAttack.getText());
    }

    @Test
    public void cardType(){
        assertEquals("Pokemon",audino.getCardType());
    }

    @Test
    public void attackTest() {
        electricAttack.attack(charmander);
        electricAttack.attack(treecko);
        electricAttack.attack(totodile);
        electricAttack.attack(audino);

        assertEquals(70, charmander.getHP());
        assertEquals(70, treecko.getHP());
        assertEquals(40, totodile.getHP());
        assertEquals(70, audino.getHP());
    }


    @Test
    public void RequiredEnergies(){
        electricAttack.receiveEnergy(electricEnergy);
        electricAttack.receiveEnergy(electricEnergy);
        electricAttack.receiveEnergy(electricEnergy);
        assertEquals(3,electricAttack.getElectricRequiredEnergies());
        electricAttack.receiveEnergy(waterEnergy);
        electricAttack.receiveEnergy(fireEnergy);
        assertEquals(1,electricAttack.getFireRequiredEnergies());
        electricAttack.receiveEnergy(fireEnergy);
        electricAttack.receiveEnergy(fireEnergy);
        assertEquals(3,electricAttack.getFireRequiredEnergies());
        assertEquals(0,electricAttack.getPsychicRequiredEnergies());
        electricAttack.receiveEnergy(pyshicEnergy);
        assertEquals(1,electricAttack.getPsychicRequiredEnergies());
        assertEquals(1,electricAttack.getWaterRequiredEnergies());
    }

    @Test
    public void equalsTest() {
        assertEquals(electricAttack, new ElectricAttack("Thunder Shock", 30,"An attack that may cause paralysis."));
        assertNotEquals(electricAttack, new WaterAttack("Bubble", 30,"An attack that may cause headache."));
        assertNotEquals(electricAttack, new WaterAttack("Not Bubble", 40,"An attack that may cause paralysis."));
        assertNotEquals(electricAttack, new FireAttack("Bubble", 40,"An attack that may cause fireheadache."));
    }

}