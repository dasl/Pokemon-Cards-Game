package cc3002.pokemon.water;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
import java.util.ArrayList;

import cc3002.pokemon.psychic.PsychicEnergy;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the Water Attack class.
 *
 * @author Diego Sandoval Leiva
 */
public class WaterAttackTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
  private IAttack waterAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    waterAttack = new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed.");
    charmander = new FirePokemon("Charmander",1, 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko",1,100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 1,100, new ArrayList<>());
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
    assertEquals("Bubble", waterAttack.getName());
    assertEquals(40, waterAttack.getBaseDamage());
  }

  @Test
  public void attackTest() {
    waterAttack.attack(charmander);
    waterAttack.attack(treecko);
    waterAttack.attack(totodile);
    waterAttack.attack(audino);

    assertEquals(20, charmander.getHP());
    assertEquals(90, treecko.getHP());
    assertEquals(60, totodile.getHP());
    assertEquals(60, audino.getHP());
  }

  @Test
  public void RequiredEnergies(){
    waterAttack.receiveEnergy(waterEnergy);
    waterAttack.receiveEnergy(fireEnergy);
    assertEquals(1,waterAttack.getFireRequiredEnergies());
    waterAttack.receiveEnergy(fireEnergy);
    waterAttack.receiveEnergy(fireEnergy);
    assertEquals(3,waterAttack.getFireRequiredEnergies());
    assertEquals(0,waterAttack.getPsychicRequiredEnergies());
    waterAttack.receiveEnergy(pyshicEnergy);
    assertEquals(1,waterAttack.getPsychicRequiredEnergies());
    assertEquals(1,waterAttack.getWaterRequiredEnergies());
  }

  @Test
  public void equalsTest() {
    assertEquals(waterAttack, new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed."));
    assertNotEquals(waterAttack, new WaterAttack("Bubble", 30,"An attack using bubbles. May lower the foe's Speed."));
    assertNotEquals(waterAttack, new WaterAttack("Not Bubble", 40,"An attack using bubbles. May lower the foe's Speed."));
    assertNotEquals(waterAttack, new FireAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed."));
  }
}