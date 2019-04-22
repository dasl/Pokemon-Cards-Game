package cc3002.pokemon.normal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class NormalPokemonTest {

  private IPokemon
      charmander,
      audino;
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
    audino = new NormalPokemon("Audino", 100,
        new ArrayList<>(Arrays.asList(normalAttack, fireAttack)));
  }

  @Test
  public void constructorTest() {
    assertEquals("Audino", audino.getName());
    assertEquals(100, audino.getHP());
    assertEquals(2, audino.getAttacks().size());
    assertEquals(normalAttack, audino.getAttacks().get(0));
    assertEquals(fireAttack, audino.getAttacks().get(1));
    assertNull(audino.getSelectedAttack());
  }

  @Test
  public void selectAttackTest() {
    audino.selectAttack(0);
    assertEquals(normalAttack, audino.getSelectedAttack());
    audino.selectAttack(1);
    assertEquals(fireAttack, audino.getSelectedAttack());
  }

  @Test
  public void attackTest() {
    audino.selectAttack(0);
    audino.attack(charmander);
    assertEquals(60, charmander.getHP());
  }

  @Test
  public void receiveWaterAttack() {
    assertEquals(100, audino.getHP());
    audino.receiveWaterAttack(waterAttack);
    assertEquals(60, audino.getHP());
  }

  @Test
  public void receiveGrassAttack() {
    assertEquals(100, audino.getHP());
    audino.receiveGrassAttack(grassAttack);
    assertEquals(55, audino.getHP());
  }

  @Test
  public void receiveFireAttack() {
    assertEquals(100, audino.getHP());
    audino.receiveFireAttack(fireAttack);
    assertEquals(60, audino.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, audino.getHP());
    audino.receiveNormalAttack(normalAttack);
    assertEquals(60, audino.getHP());
  }
}