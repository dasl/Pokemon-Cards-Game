package cc3002.pokemon.grass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
/**
 * Tests set for the GrassPokemon class.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassPokemonTest {
  private Trainer Ash;
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon
      charmander,
      treecko;

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

    charmander = new BasicFP("Charmander",1,100, new ArrayList<>());
    treecko = new BasicGP("Treecko", 1,100,
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
    assertEquals(2, treecko.getAttacks().size());
    assertEquals(grassAttack, treecko.getAttacks().get(0));
    assertEquals(normalAttack, treecko.getAttacks().get(1));
    assertNull(treecko.getSelectedAttack());
  }

  @Test
  public void cardType(){
    assertEquals("Pokemon",treecko.getCardType());
  }

  @Test
  public void receiveEnergies(){
    assertEquals(0, treecko.getFireEnergies());
    treecko.receiveEnergy(fireEnergy);
    assertEquals(1, treecko.getFireEnergies());
    treecko.receiveEnergy(electricEnergy);
    treecko.receiveEnergy(waterEnergy);
    assertEquals(1, treecko.getFireEnergies());
    assertEquals(1, treecko.getWaterEnergies());
    assertEquals(1, treecko.getElectricEnergies());
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
    assertEquals(55, charmander.getHP());
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