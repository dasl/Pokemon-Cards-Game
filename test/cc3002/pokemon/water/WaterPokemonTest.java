package cc3002.pokemon.water;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalPokemon;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class WaterPokemonTest {

  private IPokemon
      charmander,
      totodile;
  private FireAttack fireAttack;
  private GrassAttack grassAttack;
  private NormalAttack normalAttack;
  private WaterAttack waterAttack;

  @Before
  public void setUp() {
    fireAttack = new FireAttack("Ember", 40);
    grassAttack = new GrassAttack("Vine Whip", 45);
    normalAttack = new NormalAttack("Pound", 40);
    waterAttack = new WaterAttack("Bubble", 40);

    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile", 100,
        new ArrayList<>(Arrays.asList(waterAttack, normalAttack)));
  }

  @Test
  public void constructorTest() {
    assertEquals("Totodile", totodile.getName());
    assertEquals(100, totodile.getHP());
    assertEquals(2, totodile.getAttacks().size());
    assertEquals(waterAttack, totodile.getAttacks().get(0));
    assertEquals(normalAttack, totodile.getAttacks().get(1));
    assertNull(totodile.getSelectedAttack());
  }

  @Test
  public void selectAttackTest() {
    totodile.selectAttack(0);
    assertEquals(waterAttack, totodile.getSelectedAttack());
    totodile.selectAttack(1);
    assertEquals(normalAttack, totodile.getSelectedAttack());
  }

  @Test
  public void attackTest() {
    totodile.selectAttack(0);
    totodile.attack(charmander);
    assertEquals(20, charmander.getHP());
  }

  @Test
  public void receiveWaterAttack() {
    assertEquals(100, totodile.getHP());
    totodile.receiveWaterAttack(waterAttack);
    assertEquals(90, totodile.getHP());
  }

  @Test
  public void receiveGrassAttack() {
    assertEquals(100, totodile.getHP());
    totodile.receiveGrassAttack(grassAttack);
    assertEquals(10, totodile.getHP());
  }

  @Test
  public void receiveFireAttack() {
    assertEquals(100, totodile.getHP());
    totodile.receiveFireAttack(fireAttack);
    assertEquals(90, totodile.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, totodile.getHP());
    totodile.receiveNormalAttack(normalAttack);
    assertEquals(60, totodile.getHP());
  }
}