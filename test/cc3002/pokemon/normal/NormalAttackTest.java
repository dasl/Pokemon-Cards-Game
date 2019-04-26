package cc3002.pokemon.normal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.water.WaterPokemon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class NormalAttackTest {

  private IAttack normalAttack;
  private IPokemon
      charmander,
      treecko,
      totodile,
      audino;

  @Before
  public void setUp() {
    normalAttack = new NormalAttack("Pound", 40);
    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
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
  public void equalsTest() {
    assertEquals(normalAttack, new NormalAttack("Pound", 40));
    assertNotEquals(normalAttack, new NormalAttack("Pound", 30));
    assertNotEquals(normalAttack, new NormalAttack("Not Pound", 40));
    assertNotEquals(normalAttack, new FireAttack("Pound", 40));
  }
}