package cc3002.pokemon.water;

import cc3002.*;

import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests set for the WaterPokemon class.
 *
 * @author Diego Sandoval Leiva
 */

public class WaterPokemonTest {
  private Trainer Ash;
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon charmander, Feraligatr,totodile,Croconaw;
  private FireAttack fireAttack;
  private GrassAttack grassAttack;
  private NormalAttack normalAttack;
  private WaterAttack waterAttack;
  private PsychicAttack psychicAttack;
  private ElectricAttack electricAttack;

  @Before
  public void setUp() {
    psychicAttack = new PsychicAttack("Confusion", 50,"A Psychic-type attack. Has a one-in-ten chance of leaving the target confused.",new EnergyCounter());
    fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
    grassAttack = new GrassAttack("Vine Whip", 45,"Whips the foe with slender vines.",new EnergyCounter());
    normalAttack = new NormalAttack("Pound", 40,"Pounds with forelegs or tail.",new EnergyCounter());
    waterAttack = new WaterAttack("Bubble", 40,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
    electricAttack = new ElectricAttack("Thunder Shock",30,"An attack that may cause paralysis.",new EnergyCounter());

    charmander = new BasicFP("Charmander", 1,100, new ArrayList<>());


    totodile = new BasicWP("Totodile",25,100,
            new ArrayList<>(Arrays.asList(waterAttack, normalAttack)));
    Croconaw = new Phase1WP("Croconaw", 25,100,
            new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));
    Feraligatr = new Phase2WP("Feraligatr", 25,100,
            new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));

    //Creating Trainer
    Ash = new Trainer("Ash",totodile,new ArrayList<>());

    // Creating energies Cards
    // Las cartas deben poder ser jugadas por el entrenador que la tenga
    waterEnergy = new WaterEnergy();
    waterEnergy.setTrainer(Ash);
    fireEnergy = new FireEnergy();
    fireEnergy.setTrainer(Ash);
    electricEnergy = new ElectricEnergy();
    electricEnergy.setTrainer(Ash);
    grassEnergy = new GrassEnergy();
    grassEnergy.setTrainer(Ash);
    normalEnergy = new NormalEnergy();
    normalEnergy.setTrainer(Ash);
  }

  @Test
  public void constructorTest() {
    assertEquals("Totodile", totodile.getName());
    assertEquals(100, totodile.getHP());
    assertEquals(2, totodile.getAbilityList().size());
    assertEquals(waterAttack, totodile.getAbilityList().get(0));
    assertEquals(normalAttack, totodile.getAbilityList().get(1));
    assertNull(totodile.getSelectedAbility());
    assertFalse(Croconaw.equals(totodile));
    assertFalse(Feraligatr.equals(Croconaw));
    assertFalse(totodile.equals(Croconaw));
    assertTrue(totodile.equals(totodile));
    assertTrue(Feraligatr.equals(Feraligatr));
    assertTrue(Croconaw.equals(Croconaw));

  }

  @Test
  public void cardType(){
    assertEquals("Pokemon",totodile.getCardType());
  }


  @Test
  public void receiveEnergies(){
    Ash.setSelectedPokemon(totodile);
    assertEquals(0, totodile.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(fireEnergy);
    assertEquals(1, totodile.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
    Ash.getSelectedPokemon().receiveEnergy(waterEnergy);
    Ash.getSelectedPokemon().receiveEnergy(grassEnergy);
    Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
    assertEquals(1, totodile.getFireEnergies());
    assertEquals(1, totodile.getNormalEnergies());
    assertEquals(1, totodile.getElectricEnergies());
    assertEquals(1, totodile.getGrassEnergies());
  }

  @Test
  public void selectAttackTest() {
    totodile.selectAbility(0);
    assertEquals(waterAttack, totodile.getSelectedAbility());
    totodile.selectAbility(1);
    assertEquals(normalAttack, totodile.getSelectedAbility());
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