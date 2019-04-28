package cc3002.pokemon.fire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.normal.NormalPokemon;

import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;
/**
 * Tests set for the FirePokemon class.
 *
 * @author Diego Sandoval Leiva
 */
public class FirePokemonTest {
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon
      audino,
      charmander;
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
    waterEnergy = new WaterEnergy();
    fireEnergy = new FireEnergy();
    electricEnergy = new ElectricEnergy();
    grassEnergy = new GrassEnergy();
    psychicEnergy = new PsychicEnergy();
    normalEnergy = new NormalEnergy();

    audino = new NormalPokemon("Audino", 1,100, new ArrayList<>());
    charmander = new FirePokemon("Charmander",1, 100,
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
  public void cardType(){
    assertEquals("Pokemon",charmander.getCardType());
  }


  @Test
  public void receiveEnergies(){
    assertEquals(0, charmander.getFireEnergies());
    charmander.receiveEnergy(fireEnergy);
    assertEquals(1, charmander.getFireEnergies());
    charmander.receiveEnergy(electricEnergy);
    charmander.receiveEnergy(waterEnergy);
    charmander.receiveEnergy(grassEnergy);
    assertEquals(1, charmander.getFireEnergies());
    assertEquals(1, charmander.getWaterEnergies());
    assertEquals(1, charmander.getElectricEnergies());
    assertEquals(1, charmander.getGrassEnergies());
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
  public void receiveWaterAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveWaterAttack(waterAttack);
    assertEquals(20, charmander.getHP());
  }

  @Test
  public void receiveGrassAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveGrassAttack(grassAttack);
    assertEquals(55, charmander.getHP());
  }

  @Test
  public void receiveFireAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveFireAttack(fireAttack);
    assertEquals(60, charmander.getHP());
  }

  @Test
  public void receiveNormalAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveNormalAttack(normalAttack);
    assertEquals(60, charmander.getHP());
  }

  @Test
  public void receiveElectricAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receiveElectricAttack(electricAttack);
    assertEquals(70, charmander.getHP());
  }

  @Test
  public void receivePsychicAttack() {
    assertEquals(100, charmander.getHP());
    charmander.receivePsychicAttack(psychicAttack);
    assertEquals(50, charmander.getHP());
  }

}