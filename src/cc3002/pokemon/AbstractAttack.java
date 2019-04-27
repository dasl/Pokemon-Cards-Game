package cc3002.pokemon;

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
  private List<IEnergy> fireRequiredEnergies,
          waterRequiredEnergies,
          electricRequiredEnergies,
          grassRequiredEnergies,
          psychicRequiredEnergies,
          normalRequiredEnergies;

  /**
   * Creates a new attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  protected AbstractAttack(String name, int baseDamage,String text) {
    this.baseDamage = baseDamage;
    this.name = name;
    this.text = text;
    this.fireRequiredEnergies = new ArrayList<>();
    this.waterRequiredEnergies = new ArrayList<>();
    this.grassRequiredEnergies = new ArrayList<>();
    this.normalRequiredEnergies = new ArrayList<>();
    this.psychicRequiredEnergies = new ArrayList<>();
    this.electricRequiredEnergies = new ArrayList<>();
  }
  //region Properties
  @Override
  public void setFireRequiredEnergies(FireEnergy energy) {this.fireRequiredEnergies.add(energy); }
  @Override
  public void setWaterRequiredEnergies(WaterEnergy energy) {this.waterRequiredEnergies.add(energy); }
  @Override
  public void setElectricRequiredEnergies(ElectricEnergy energy) {this.electricRequiredEnergies.add(energy); }
  @Override
  public void setPsychicRequiredEnergies(PsychicEnergy energy) {this.psychicRequiredEnergies.add(energy); }
  @Override
  public void setGrassRequiredEnergies(GrassEnergy energy) {this.grassRequiredEnergies.add(energy); }
  @Override
  public void setNormalRequiredEnergies(NormalEnergy energy) {this.normalRequiredEnergies.add(energy); }


  public void receiveEnergy(IEnergy energy){
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
    return this.fireRequiredEnergies.size();
  }

  @Override
  public int getWaterRequiredEnergies() {
    return this.waterRequiredEnergies.size();
  }

  @Override
  public int getGrassRequiredEnergies() {
    return this.grassRequiredEnergies.size();
  }

  @Override
  public int getElectricRequiredEnergies() {
    return this.electricRequiredEnergies.size();
  }
  @Override
  public int getNormalRequiredEnergies() {
    return this.normalRequiredEnergies.size();
  }
  @Override
  public int getPsychicRequiredEnergies() {
    return this.psychicRequiredEnergies.size();
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
