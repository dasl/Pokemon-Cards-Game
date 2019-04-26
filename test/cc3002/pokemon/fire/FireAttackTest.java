package cc3002.pokemon.fire;

import static org.junit.Assert.*;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
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
 * @author Ignacio Slater Muñoz
 */
public class FireAttackTest {
  private FireEnergy fireEnergy;
  private WaterEnergy waterEnergy;
  private ElectricEnergy electricEnergy;
  private GrassEnergy grassEnergy;
  private NormalEnergy normalEnergy;
  private PsychicEnergy psychicEnergy;

  private IAttack fireAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    fireAttack = new FireAttack("Ember", 40);
    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
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
  fireAttack.setFireRequiredEnergies(fireEnergy);
  assertEquals(1,fireAttack.getFireRequiredEnergies());
  fireAttack.setFireRequiredEnergies(fireEnergy);
  fireAttack.setFireRequiredEnergies(fireEnergy);
  assertEquals(3,fireAttack.getFireRequiredEnergies());
}


  @Test
  public void equalsTest() {
    assertEquals(fireAttack, new FireAttack("Ember", 40));
    assertNotEquals(fireAttack, new FireAttack("Ember", 30));
    assertNotEquals(fireAttack, new FireAttack("Not Ember", 40));
    assertNotEquals(fireAttack, new WaterAttack("Ember", 40));
  }
}