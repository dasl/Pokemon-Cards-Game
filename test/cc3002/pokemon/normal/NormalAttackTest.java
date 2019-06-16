package cc3002.pokemon.normal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cc3002.pokemon.Abilities.attacks.IAttack;
import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.BasicGP;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.BasicWP;
import cc3002.pokemon.water.WaterEnergy;
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
    normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter());
    charmander = new BasicFP("Charmander", 1,100, new ArrayList<>());
    treecko = new BasicGP("Treecko",1,100, new ArrayList<>());
    totodile = new BasicWP("Totodile",1, 100, new ArrayList<>());
    audino = new BasicNP("Audino", 1,100, new ArrayList<>());
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
    normalAttack.receiveRequiredEnergy(waterEnergy);
    normalAttack.receiveRequiredEnergy(normalEnergy);
    normalAttack.receiveRequiredEnergy(normalEnergy);
    normalAttack.receiveRequiredEnergy(normalEnergy);
    normalAttack.receiveRequiredEnergy(fireEnergy);
    assertEquals(3,normalAttack.getNormalRequiredEnergies());
    assertEquals(1,normalAttack.getFireRequiredEnergies());
    normalAttack.receiveRequiredEnergy(fireEnergy);
    normalAttack.receiveRequiredEnergy(fireEnergy);
    assertEquals(3,normalAttack.getFireRequiredEnergies());
    assertEquals(0,normalAttack.getPsychicRequiredEnergies());
    normalAttack.receiveRequiredEnergy(pyshicEnergy);
    assertEquals(1,normalAttack.getPsychicRequiredEnergies());
    assertEquals(1,normalAttack.getWaterRequiredEnergies());
  }
  @Test
  public void equalsTest() {
    assertEquals(normalAttack, new NormalAttack("Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter()));
    assertNotEquals(normalAttack, new NormalAttack("Pound", 30,"Pounds with forelegs or tail.",new EnergyCounter()));
    assertNotEquals(normalAttack, new NormalAttack("Not Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter()));
    assertNotEquals(normalAttack, new FireAttack("Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter()));
  }
}