package cc3002.pokemon.normal;

import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
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
 * Tests set for the NormalPokemon class.
 *
 * @author Diego Sandoval Leiva
 */


public class NormalPokemonTest {
  private Trainer Ash;
  private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, psychicEnergy, normalEnergy;
  private IPokemon charmander, audino,megaudino,ultraudino;
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

    audino = new BasicNP("Audino",19, 100,
        new ArrayList<>(Arrays.asList(normalAttack, fireAttack)));
    megaudino = new Phase1NP("Meagudino",19, 100,
            new ArrayList<>(Arrays.asList(normalAttack, fireAttack)));
    ultraudino = new Phase2NP("Ultraudino",19, 100,
            new ArrayList<>(Arrays.asList(normalAttack, fireAttack)));

    //Creating Trainer
    Ash = new Trainer("Ash",audino,new ArrayList<>());

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
    assertEquals("Audino", audino.getName());
    assertEquals(100, audino.getHP());
    assertEquals(2, audino.getAbilityList().size());
    assertEquals(normalAttack, audino.getAbilityList().get(0));
    assertEquals(fireAttack, audino.getAbilityList().get(1));
    assertNull(audino.getSelectedAbility());
    assertFalse(ultraudino.equals(megaudino));
    assertFalse(megaudino.equals(audino));
  }
  @Test
  public void cardType(){
    assertEquals("Pokemon",audino.getCardType());
  }


  @Test
  public void receiveEnergies(){
    Ash.setSelectedPokemon(audino);
    assertEquals(0, audino.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(fireEnergy);
    assertEquals(1, audino.getFireEnergies());
    Ash.getSelectedPokemon().receiveEnergy(electricEnergy);
    Ash.getSelectedPokemon().receiveEnergy(waterEnergy);
    Ash.getSelectedPokemon().receiveEnergy(grassEnergy);
    Ash.getSelectedPokemon().receiveEnergy(normalEnergy);
    assertEquals(1, audino.getFireEnergies());
    assertEquals(1, audino.getNormalEnergies());
    assertEquals(1, audino.getElectricEnergies());
    assertEquals(1, audino.getGrassEnergies());
  }
  @Test
  public void selectAttackTest() {
    audino.selectAbility(0);
    assertEquals(normalAttack, audino.getSelectedAbility());
    audino.selectAbility(1);
    assertEquals(fireAttack, audino.getSelectedAbility());
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