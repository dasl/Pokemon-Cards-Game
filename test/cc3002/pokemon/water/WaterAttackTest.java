package cc3002.pokemon.water;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalPokemon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the FireAttack class.
 *
 * @author Ignacio Slater Muñoz
 */
public class WaterAttackTest {

  private IAttack waterAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    waterAttack = new WaterAttack("Bubble", 40);
    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
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
    assertEquals(90, totodile.getHP());
    assertEquals(60, audino.getHP());
  }

  @Test
  public void equalsTest() {
    assertEquals(waterAttack, new WaterAttack("Bubble", 40));
    assertNotEquals(waterAttack, new WaterAttack("Bubble", 30));
    assertNotEquals(waterAttack, new WaterAttack("Not Bubble", 40));
    assertNotEquals(waterAttack, new FireAttack("Bubble", 40));
  }
}