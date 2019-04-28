package cc3002.pokemon.normal;

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
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
/**
 * Tests set for the NormalAttack class.
 *
 * @author Diego Sandoval Leiva
 */
public class NormalAttackTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
  private IAttack normalAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.");
    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko",100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    pyshicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();
  }

  @Test
  public void constructorTest() {
    assertEquals("Pound", normalAttack.getName());
    assertEquals(40, normalAttack.getBaseDamage());
  }

  @Test
  public void attackTest() {
    normalAttack.attack(charmander);
    normalAttack.attack(treecko);
    normalAttack.attack(totodile);
    normalAttack.attack(audino);

    assertEquals(60, charmander.getHP());
    assertEquals(60, treecko.getHP());
    assertEquals(90, totodile.getHP());
    assertEquals(60, audino.getHP());
  }

  @Test
  public void RequiredEnergies(){
    normalAttack.receiveEnergy(waterEnergy);
    normalAttack.receiveEnergy(normalEnergy);
    normalAttack.receiveEnergy(normalEnergy);
    normalAttack.receiveEnergy(normalEnergy);
    normalAttack.receiveEnergy(fireEnergy);
    assertEquals(3,normalAttack.getNormalRequiredEnergies());
    assertEquals(1,normalAttack.getFireRequiredEnergies());
    normalAttack.receiveEnergy(fireEnergy);
    normalAttack.receiveEnergy(fireEnergy);
    assertEquals(3,normalAttack.getFireRequiredEnergies());
    assertEquals(0,normalAttack.getPsychicRequiredEnergies());
    normalAttack.receiveEnergy(pyshicEnergy);
    assertEquals(1,normalAttack.getPsychicRequiredEnergies());
    assertEquals(1,normalAttack.getWaterRequiredEnergies());
  }
  @Test
  public void equalsTest() {
    assertEquals(normalAttack, new NormalAttack("Pound", 40,"Pounds with forelegs or tail."));
    assertNotEquals(normalAttack, new NormalAttack("Pound", 30,"Pounds with forelegs or tail."));
    assertNotEquals(normalAttack, new NormalAttack("Not Pound", 40,"Pounds with forelegs or tail."));
    assertNotEquals(normalAttack, new FireAttack("Pound", 40,"Pounds with forelegs or tail."));
  }
}