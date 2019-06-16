package cc3002.pokemon.grass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cc3002.pokemon.Abilities.attacks.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.normal.BasicNP;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.BasicWP;
import cc3002.pokemon.water.WaterEnergy;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the GrassAttack class.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassAttackTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;

  private IAttack grassAttack, normalAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    grassAttack = new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines.");
    normalAttack = new NormalAttack("Combito", 50,"The best attack of game, is lethal");
    charmander = new BasicFP("Charmander", 1,100, new ArrayList<>());
    treecko = new BasicGP("Treecko", 1,100, new ArrayList<>());
    totodile = new BasicWP("Totodile", 1,100, new ArrayList<>());
    audino = new BasicNP("Audino",1,100, new ArrayList<>());
    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    pyshicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();

  }

  @Test
  public void constructorTest() {
    assertEquals("Vine Whip", grassAttack.getName());
    assertEquals(45, grassAttack.getBaseDamage());
  }

  @Test
  public void attackTest() {
    grassAttack.attack(charmander);
    grassAttack.attack(treecko);
    grassAttack.attack(totodile);
    grassAttack.attack(audino);

    assertEquals(55, charmander.getHP());
    assertEquals(55, treecko.getHP());
    assertEquals(10, totodile.getHP());
    assertEquals(10, audino.getHP());
  }

  @Test
  public void RequiredEnergies(){
    grassAttack.receiveRequiredEnergy(grassEnergy);
    grassAttack.receiveRequiredEnergy(fireEnergy);
    assertEquals(1,grassAttack.getGrassRequiredEnergies());
    grassAttack.receiveRequiredEnergy(fireEnergy);
    grassAttack.receiveRequiredEnergy(fireEnergy);
    assertEquals(3,grassAttack.getFireRequiredEnergies());
    assertEquals(0,grassAttack.getPsychicRequiredEnergies());
    grassAttack.receiveRequiredEnergy(pyshicEnergy);
    assertEquals(1,grassAttack.getPsychicRequiredEnergies());
    assertEquals(0,grassAttack.getWaterRequiredEnergies());
    assertEquals(0,normalAttack.getWaterRequiredEnergies());
  }

  @Test
  public void equalsTest() {
    assertEquals(grassAttack, new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines."));
    assertNotEquals(grassAttack, new GrassAttack("Vine Whip", 30,"Whips the foe with slender vines."));
    assertNotEquals(grassAttack, new GrassAttack("Not Vine Whip", 45,"Whips the foe with slender vines."));
    assertNotEquals(grassAttack, new FireAttack("Vine Whip", 45,"Whips the foe with slender vines."));
  }
}