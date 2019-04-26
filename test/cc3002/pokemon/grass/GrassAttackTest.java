package cc3002.pokemon.grass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterPokemon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the GrassAttack class.
 *
 * @author Ignacio Slater Muñoz
 */
public class GrassAttackTest {

  private IAttack grassAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    grassAttack = new GrassAttack("Vine Whip", 45);
    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
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
  public void equalsTest() {
    assertEquals(grassAttack, new GrassAttack("Vine Whip", 45));
    assertNotEquals(grassAttack, new GrassAttack("Vine Whip", 30));
    assertNotEquals(grassAttack, new GrassAttack("Not Vine Whip", 45));
    assertNotEquals(grassAttack, new FireAttack("Vine Whip", 45));
  }
}