package cc3002.pokemon.grass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class GrassPokemonTest {

  private IPokemon
      charmander,
      treecko;
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
    treecko = new GrassPokemon("Treecko", 100,
        new ArrayList<>(Arrays.asList(grassAttack, normalAttack)));
  }

  @Test
  public void constructorTest() {
    assertEquals("Treecko", treecko.getName());
    assertEquals(100, treecko.getHP());
    assertEquals(2, treecko.getAttacks().size());
    assertEquals(grassAttack, treecko.getAttacks().get(0));
    assertEquals(normalAttack, treecko.getAttacks().get(1));
    assertNull(treecko.getSelectedAttack());
  }

  @Test
  public void selectAttackTest() {
    treecko.selectAttack(0);
    assertEquals(grassAttack, treecko.getSelectedAttack());
    treecko.selectAttack(1);
    assertEquals(normalAttack, treecko.getSelectedAttack());
  }

  @Test
  public void attackTest() {
    treecko.selectAttack(0);
    treecko.attack(charmander);
    assertEquals(85, charmander.getHP());
  }

  @Test
  public void receiveWaterAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receiveWaterAttack(waterAttack);
    assertEquals(90, treecko.getHP());
  }

  @Test
  public void receiveGrassAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receiveGrassAttack(grassAttack);
    assertEquals(85, treecko.getHP());
  }

  @Test
  public void receiveFireAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receiveFireAttack(fireAttack);
    assertEquals(20, treecko.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receiveNormalAttack(normalAttack);
    assertEquals(60, treecko.getHP());
  }
}