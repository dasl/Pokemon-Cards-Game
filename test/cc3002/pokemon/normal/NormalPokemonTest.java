package cc3002.pokemon.normal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests set for the NormalPokemon class.
 *
 * @author Diego Sandoval Leiva
 */


public class NormalPokemonTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon
      charmander,
      audino;
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

    charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
    audino = new NormalPokemon("Audino", 100,
        new ArrayList<>(Arrays.asList(normalAttack, fireAttack)));

    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    psychicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();
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
  public void cardType(){
    assertEquals("Pokemon",audino.getCardType());
  }


  @Test
  public void receiveEnergies(){
    assertEquals(0, audino.getFireEnergies());
    audino.receiveEnergy(fireEnergy);
    assertEquals(1, audino.getFireEnergies());
    audino.receiveEnergy(electricEnergy);
    audino.receiveEnergy(waterEnergy);
    audino.receiveEnergy(grassEnergy);
    audino.receiveEnergy(normalEnergy);
    assertEquals(1, audino.getFireEnergies());
    assertEquals(1, audino.getNormalEnergies());
    assertEquals(1, audino.getElectricEnergies());
    assertEquals(1, audino.getGrassEnergies());
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
    assertEquals(10, audino.getHP());
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