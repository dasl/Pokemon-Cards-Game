package cc3002.pokemon.water;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;
import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the WaterPokemon class.
 *
 * @author Diego Sandoval Leiva
 */

public class WaterPokemonTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon
      charmander,
      totodile;
  private FireAttack fireAttack;
  private GrassAttack grassAttack;
  private NormalAttack normalAttack;
  private WaterAttack waterAttack;
  private PsychicAttack psychicAttack;
  private ElectricAttack electricAttack;

  @Before
  public void setUp() {
    psychicAttack = new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused.");
    fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
    grassAttack = new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines.");
    normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.");
    waterAttack = new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed.");
    electricAttack = new ElectricAttack("Thunder Shock",30,"An attack that may cause paralysis.");

    charmander = new FirePokemon("Charmander",1, 100, new ArrayList<>());
    totodile = new WaterPokemon("Totodile",1,100,
        new ArrayList<>(Arrays.asList(waterAttack, normalAttack)));

    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    psychicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();
  }

  @Test
  public void constructorTest() {
    assertEquals("Totodile", totodile.getName());
    assertEquals(1, totodile.getId());
    assertEquals(100, totodile.getHP());
    assertEquals(2, totodile.getAttacks().size());
    assertEquals(waterAttack, totodile.getAttacks().get(0));
    assertEquals(normalAttack, totodile.getAttacks().get(1));
    assertNull(totodile.getSelectedAttack());
  }

  @Test
  public void cardType(){
    assertEquals("Pokemon",totodile.getCardType());
  }


  @Test
  public void receiveEnergies(){
    assertEquals(0, totodile.getFireEnergies());
    totodile.receiveEnergy(fireEnergy);
    assertEquals(1, totodile.getFireEnergies());
    totodile.receiveEnergy(electricEnergy);
    totodile.receiveEnergy(waterEnergy);
    totodile.receiveEnergy(grassEnergy);
    totodile.receiveEnergy(normalEnergy);
    assertEquals(1, totodile.getFireEnergies());
    assertEquals(1, totodile.getNormalEnergies());
    assertEquals(1, totodile.getElectricEnergies());
    assertEquals(1, totodile.getGrassEnergies());
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
    assertEquals(60, totodile.getHP());
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
    assertEquals(60, totodile.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, totodile.getHP());
    totodile.receiveNormalAttack(normalAttack);
    assertEquals(90, totodile.getHP());
  }
}