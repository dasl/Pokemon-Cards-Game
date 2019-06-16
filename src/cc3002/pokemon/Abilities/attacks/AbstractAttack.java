package cc3002.pokemon.Abilities.attacks;

import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and base damage.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractAttack implements IAttack {


  private int baseDamage;
  private String text;
  private String name;
  private EnergyCounter costs;

  /**
   * Creates a new attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  protected AbstractAttack(String name, int baseDamage, String text, EnergyCounter costs) {
    this.baseDamage = baseDamage;
    this.name = name;
    this.text = text;
    this.costs = costs;

  }

  @Override
  public void accept(IAbilityVisitor IAbilityVisitor){
      IAbilityVisitor.visitAttack(this);
  }


  @Override
  public void applyEffect(Trainer abstractPokemon){}

  //region Properties
  @Override
  public void setFireRequiredEnergies(FireEnergy energy) {this.costs.setFireEnergy(); }
  @Override
  public void setWaterRequiredEnergies(WaterEnergy energy) {this.costs.setWaterEnergy(); }
  @Override
  public void setElectricRequiredEnergies(ElectricEnergy energy) {this.costs.setElectricEnergy(); }
  @Override
  public void setPsychicRequiredEnergies(PsychicEnergy energy) {this.costs.setPsychicEnergy(); }
  @Override
  public void setGrassRequiredEnergies(GrassEnergy energy) {this.costs.setGrassEnergy(); }
  @Override
  public void setNormalRequiredEnergies(NormalEnergy energy) {this.costs.setNormalEnergy(); }


  public void receiveRequiredEnergy(IEnergy energy){
    energy.addInto(this);
  }

  @Override
  public int getBaseDamage() {
    return baseDamage;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getText() {return text;}
  //endregion


  @Override
  public int getFireRequiredEnergies() {
    return this.costs.getFireEnergy();
  }
  @Override
  public int getWaterRequiredEnergies() {
    return this.costs.getWaterEnergy();
  }
  @Override
  public int getGrassRequiredEnergies() {
    return this.costs.getGrassEnergy();
  }
  @Override
  public int getElectricRequiredEnergies() {
    return this.costs.getElectricEnergy();
  }
  @Override
  public int getNormalRequiredEnergies() {
    return this.costs.getNormalEnergy();
  }
  @Override
  public int getPsychicRequiredEnergies() {
    return this.costs.getPyshicEnergy();
  }


  /**
   * Checks if this attack is equal to another.
   *
   * @param obj Object to compare this attack.
   * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
        && ((IAttack) obj).getName().equals(name);
  }

}
