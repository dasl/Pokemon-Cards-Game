package cc3002.pokemon.fire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalPokemon;

import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

public class FirePokemonTest {

  private IPokemon
      audino,
      charmander;
  private FireEnergy fireEnergy;
  private WaterEnergy waterEnergy;
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

    audino = new NormalPokemon("Audino", 100, new ArrayList<>());
    charmander = new FirePokemon("Charmander", 100,
        new ArrayList<>(Arrays.asList(fireAttack, normalAttack)));
  }

  @Test
  public void constructorTest() {
    assertEquals("Charmander", charmander.getName());
    assertEquals(100, charmander.getHP());
    assertEquals(2, charmander.getAttacks().size());
    assertEquals(fireAttack, charmander.getAttacks().get(0));
    assertEquals(normalAttack, charmander.getAttacks().get(1));
    assertNull(charmander.getSelectedAttack());
  }

  @Test
  public void selectAttackTest() {
    charmander.selectAttack(0);
    assertEquals(fireAttack, charmander.getSelectedAttack());
    charmander.selectAttack(1);
    assertEquals(normalAttack, charmander.getSelectedAttack());
  }

  @Test
  public void attackTest() {
    charmander.selectAttack(0);
    charmander.attack(audino);
    assertEquals(60, audino.getHP());
  }

  @Test
  public void receiveFireEnergy(){
    assertEquals(0, charmander.getFireEnergies());
    charmander.receiveFireEnergy(fireEnergy);
    assertEquals(1, charmander.getFireEnergies());
    charmander.receiveFireEnergy(fireEnergy);
    assertEquals(0, audino.getFireEnergies());
    assertEquals(2, charmander.getFireEnergies());
    assertEquals(0, charmander.getWaterEnergies());
    assertEquals(0, charmander.getElectricEnergies());
    assertEquals(0, charmander.getGrassEnergies());

  }

  @Test
  public void receiveWaterAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveWaterAttack(waterAttack);
    assertEquals(20, charmander.getHP());
  }

  @Test
  public void receiveGrassAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveGrassAttack(grassAttack);
    assertEquals(85, charmander.getHP());
  }

  @Test
  public void receiveFireAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveFireAttack(fireAttack);
    assertEquals(90, charmander.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveNormalAttack(normalAttack);
    assertEquals(60, charmander.getHP());
  }
}