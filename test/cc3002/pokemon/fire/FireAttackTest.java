package cc3002.pokemon.fire;

import static org.junit.Assert.*;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the FireAttack class.
 * 
 * @author Diego Sandoval Leiva
 */
public class FireAttackTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;

  private IAttack fireAttack, normalAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
    normalAttack = new NormalAttack("Combito", 50,"The best attack of game, is lethal");
    charmander = new FirePokemon("Charmander", 1,100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko",1, 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile",1, 100, new ArrayList<>());
    audino = new NormalPokemon("Audino",1, 100, new ArrayList<>());
    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    pyshicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();
  }

  @Test
  public void constructorTest() {
    assertEquals("Ember", fireAttack.getName());
    assertEquals(40, fireAttack.getBaseDamage());
  }

  @Test
  public void attackTest() {
    fireAttack.attack(charmander);
    fireAttack.attack(treecko);
    fireAttack.attack(totodile);
    fireAttack.attack(audino);
    assertEquals(60, charmander.getHP());
    assertEquals(20, treecko.getHP());
    assertEquals(60, totodile.getHP());
    assertEquals(60, audino.getHP());
  }

@Test
  public void RequiredEnergies(){
  fireAttack.receiveRequiredEnergy(waterEnergy);
  fireAttack.receiveRequiredEnergy(fireEnergy);
  assertEquals(1,fireAttack.getFireRequiredEnergies());
  fireAttack.receiveRequiredEnergy(fireEnergy);
  fireAttack.receiveRequiredEnergy(fireEnergy);
  assertEquals(3,fireAttack.getFireRequiredEnergies());
  assertEquals(0,fireAttack.getPsychicRequiredEnergies());
  fireAttack.receiveRequiredEnergy(pyshicEnergy);
  assertEquals(1,fireAttack.getPsychicRequiredEnergies());
  assertEquals(1,fireAttack.getWaterRequiredEnergies());
  assertEquals(0,normalAttack.getWaterRequiredEnergies());
}


  @Test
  public void equalsTest() {
    assertEquals(fireAttack, new FireAttack("Ember", 40,"An attack that may inflict a burn."));
    assertNotEquals(fireAttack, new FireAttack("Ember", 30,"An attack that may inflict a burn."));
    assertNotEquals(fireAttack, new FireAttack("Not Ember", 40,"An attack that may inflict a burn."));
    assertNotEquals(fireAttack, new WaterAttack("Ember", 40,"An attack that may inflict a burn."));
  }
}