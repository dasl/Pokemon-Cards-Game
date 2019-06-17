package cc3002.pokemon.grass;

import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.ArrayList;
import java.util.Arrays;

import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/**
 * Tests set for the GrassPokemon class.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassPokemonTest {
  private Trainer Ash;
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon charmander, grovyle,sceptile,treecko;

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

    charmander = new BasicFP("Charmander",1,100, new ArrayList<>());
    treecko = new BasicGP("Treecko", 13,100,
        new ArrayList<>(Arrays.asList(grassAttack, normalAttack)));
    grovyle = new Phase1GP("Grovyle", 13,100,
            new ArrayList<>(Arrays.asList(grassAttack, normalAttack)));
    sceptile = new Phase2GP("Sceptile", 13,100,
            new ArrayList<>(Arrays.asList(grassAttack, normalAttack)));

    //Creating Trainer
    Ash = new Trainer("Ash",treecko,new ArrayList<>());

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
    assertEquals("Treecko", treecko.getName());
    assertEquals(100, treecko.getHP());
    assertEquals(2, treecko.getAbilityList().size());
    assertEquals(grassAttack, treecko.getAbilityList().get(0));
    assertEquals(normalAttack, treecko.getAbilityList().get(1));
    assertNull(treecko.getSelectedAbility());
    assertFalse(sceptile.equals(grovyle));
    assertFalse(grovyle.equals(treecko));
    assertTrue(treecko.equals(treecko));
    assertTrue(grovyle.equals(grovyle));
    assertTrue(sceptile.equals(sceptile));
    assertFalse(treecko.equals(sceptile));
  }

  @Test
  public void cardType(){
    assertEquals("Pokemon",treecko.getCardType());
  }

  @Test
  public void receiveEnergies(){
    Ash.setSelectedPokemon(treecko);
    assertEquals(0, treecko.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(fireEnergy);
    assertEquals(1, treecko.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
    Ash.getSelectedPokemon().receiveEnergy(waterEnergy);
    assertEquals(1, treecko.getFireEnergies());
    assertEquals(1, treecko.getWaterEnergies());
    assertEquals(1, treecko.getElectricEnergies());
  }

  @Test
  public void selectAttackTest() {
    treecko.selectAbility(0);
    assertEquals(grassAttack, treecko.getSelectedAbility());
    treecko.selectAbility(1);
    assertEquals(normalAttack, treecko.getSelectedAbility());
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
    assertEquals(55, treecko.getHP());
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

  @Test
  public void receiveElectricAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receiveElectricAttack(electricAttack);
    assertEquals(70, treecko.getHP());
  }

  @Test
  public void receivePsychicAttack() {
    assertEquals(100, treecko.getHP());
    treecko.receivePsychicAttack(psychicAttack);
    assertEquals(50,treecko.getHP());
  }
}