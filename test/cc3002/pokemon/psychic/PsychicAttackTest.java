package cc3002.pokemon.psychic;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.electric.ElectricPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests set for the PsychicAttack class.
 *
 * @author Diego Sandoval Leiva
 */

public class PsychicAttackTest {
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
    private IAttack psyshicAttack;
    private IPokemon
            slowpoke,
            mew,
            kadabra,
            abra,
            charmander,
            treecko,
            totodile,
            audino;

    @Before
    public void setUp(){
        psyshicAttack = new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused.");
        charmander = new FirePokemon("Charmander",1,100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 1,100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile",1, 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 1,100, new ArrayList<>());
        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        electricEnergy = new ElectricEnergy();
        grassEnergy = new GrassEnergy();
        pyshicEnergy = new PsychicEnergy();
        normalEnergy = new NormalEnergy();
    }

    @Test
    public void constructorTest() {
        assertEquals("Confusion", psyshicAttack.getName());
        assertEquals(50, psyshicAttack.getBaseDamage());
    }

    @Test
    public void attackTest() {
        psyshicAttack.attack(charmander);
        psyshicAttack.attack(treecko);
        psyshicAttack.attack(totodile);
        psyshicAttack.attack(audino);

        assertEquals(50, charmander.getHP());
        assertEquals(50, treecko.getHP());
        assertEquals(50, totodile.getHP());
        assertEquals(0, audino.getHP());
    }
    @Test
    public void RequiredEnergies(){
        psyshicAttack.receiveEnergy(waterEnergy);
        psyshicAttack.receiveEnergy(fireEnergy);
        assertEquals(1, psyshicAttack.getFireRequiredEnergies());
        psyshicAttack.receiveEnergy(fireEnergy);
        psyshicAttack.receiveEnergy(fireEnergy);
        assertEquals(3, psyshicAttack.getFireRequiredEnergies());
        assertEquals(0, psyshicAttack.getPsychicRequiredEnergies());
        psyshicAttack.receiveEnergy(pyshicEnergy);
        assertEquals(1, psyshicAttack.getPsychicRequiredEnergies());
        assertEquals(1, psyshicAttack.getWaterRequiredEnergies());
    }
    @Test
    public void equalsTest() {
        assertEquals(psyshicAttack, new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused."));
        assertNotEquals(psyshicAttack, new WaterAttack("Bubble", 30,"An attack using bubbles. May lower the foe's Speed."));
        assertNotEquals(psyshicAttack, new WaterAttack("Not Bubble", 40,"An attack using bubbles. May lower the foe's Speed."));
        assertNotEquals(psyshicAttack, new FireAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed."));
    }
}