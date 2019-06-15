package cc3002.pokemon;

import cc3002.pokemon.Abilities.*;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that represents a generic Pokémon. This class contains the necessary methods to
 * attack and receive damage, and definitions to get the properties of each Pokémon, like its name
 * and hp.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon {
  private String typeCard;
  private String name;
  private IAbilities selectedAbility;
  private int id;
  private int hp;
  private List<IAbilities> abilities;
  private IAttack selectedAttack;
  private List<WaterEnergy> waterEnergies;
  private List<FireEnergy> fireEnergies;
  private List<ElectricEnergy> electricEnergies;
  private List<GrassEnergy > grassEnergies;
  private List<PsychicEnergy> psychicEnergies;
  private List<NormalEnergy> normalEnergies;

  /**
   * Creates a new Pokémon.
   *
   * @param name  Pokémon's name.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's abilities.
   */
  protected AbstractPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
    this.typeCard = "Pokemon";
    this.name = name;
    this.id = id;
    this.hp = hp;
    this.abilities = abilitiesList;
    this.waterEnergies = new ArrayList<>();
    this.fireEnergies = new ArrayList<>();
    this.electricEnergies = new ArrayList<>();
    this.grassEnergies = new ArrayList<>();
    this.psychicEnergies = new ArrayList<>();
    this.normalEnergies = new ArrayList<>();
  }

  /**
   * Receives an energy from a water energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveWaterEnergy(WaterEnergy energy) { this.waterEnergies.add(energy);}


  /**
   * Receives an energy from a grass energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveGrassEnergy(GrassEnergy energy) {this.grassEnergies.add(energy);}

  /**
   * Receives an energy from a fire energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveFireEnergy(FireEnergy energy) { this.fireEnergies.add(energy);}


  /**
   * Receives an energy from a normal energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveNormalEnergy(NormalEnergy energy) {this.normalEnergies.add(energy);}

  /**
   * Receives an energy from a psychic energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receivePsychicEnergy(PsychicEnergy energy) {this.psychicEnergies.add(energy);}


  /**
   * Receives an energy from a electric energy.
   *
   * @param energy Received energy.
   */
  public void receiveElectricEnergy(ElectricEnergy energy) {this.electricEnergies.add(energy);}


  /**
   * Receives an energy.
   *
   * @param energy Receive energy.
   */
  @Override
  public void receiveEnergy(IEnergy energy){
    energy.addToPoke();
  }



  /**
   * Attacks another Pokémon.
   *
   * @param other Target of the attack.
   */
  @Override
  public void attack(IPokemon other) {
    selectedAttack.attack(other);
  }


  /**
   * Receives damage from a water attack.
   *
   * @param attack Received attack.
   */

  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveAttack(attack);
  }
  /**
   * Receives damage from a fire attack.
   *
   * @param attack Received attack.
   */
  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveAttack(attack);
  }


  /**
   * Receives damage from a fire attack.
   *
   * @param attack Received attack.
   */
  @Override
  public void receiveFireAttack(FireAttack attack) {
    receiveAttack(attack);
  }


  /**
   * Receives damage from a normal attack.
   *
   * @param attack Received attack.
   */
  @Override
  public void receiveNormalAttack(NormalAttack attack) {
    receiveAttack(attack);
  }


  /**
   * Receives damage from a psychic attack.
   *
   * @param attack Received attack.
   */
  @Override
  public void receivePsychicAttack(PsychicAttack attack) {
    receiveAttack(attack);
  }


  /**
   * Receives damage from a electric attack.
   *
   * @param attack Received attack
   */
  @Override
  public void receiveElectricAttack(ElectricAttack attack) {
    receiveAttack(attack);
  }


  /**
   * Receives an attack.
   * @param attack  Received attack.
   */
  protected void receiveAttack(IAttack attack) {
    this.hp -= attack.getBaseDamage();
  }

  /**
   * Receives an attack to which this Pokémon is weak.
   * @param attack  Received attack.
   */
  protected void receiveWeaknessAttack(IAttack attack) {
    this.hp -= attack.getBaseDamage() * 2;
  }

  /**
   * Receives an attack to which this Pokémon is resistant.
   * @param attack  Received attack.
   */
  protected void receiveResistantAttack(IAttack attack) {
    this.hp -= attack.getBaseDamage() - 30;
  }

  //region Properties
  @Override
  public String getCardType(){
    return typeCard;
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getFireEnergies() {
    return this.fireEnergies.size();
  }

  @Override
  public int getWaterEnergies() {
    return this.waterEnergies.size();
  }

  @Override
  public int getElectricEnergies() {
    return this.electricEnergies.size();
  }

  @Override
  public int getGrassEnergies() {
    return this.grassEnergies.size();
  }

  @Override
  public int getNormalEnergies() {
    return this.normalEnergies.size();
  }

  @Override
  public int getPsychicEnergies() {
    return this.psychicEnergies.size();
  }

  @Override
  public int getHP() {
    return hp;
  }

  @Override
  public int getID() {
    return id;
  }

  @Override
  public void resetEnergies(){
    this.electricEnergies.clear();
    this.waterEnergies.clear();
    this.fireEnergies.clear();
    this.psychicEnergies.clear();
    this.normalEnergies.clear();
    this.grassEnergies.clear();
  }


  @Override
  public void selectAbility(int index) {
    this.selectedAbility = abilities.get(index);
  }


    @Override
    public IAbilities getSelectedAbility() {
        return this.selectedAbility;
    }


  /**
   * Use an ability .
   *
   * @param adversary Adversary of the attack.
   */
  @Override
  public void useAbility(Trainer adversary) {
    ConcreteIAbilityVisitor concreteIAbilityVisitor = new ConcreteIAbilityVisitor();
    AttackVisitor attackVisitor = new AttackVisitor();
    if (this.selectedAbility.getBaseDamage()==-1){
      this.selectedAbility.accept(concreteIAbilityVisitor);
      concreteIAbilityVisitor.getAbility().applyEffect(adversary);
    }
    else{
      this.selectedAbility.accept(attackVisitor);
      attackVisitor.getAttack().attack(adversary.getActivePokemon());}
  }


  /**
   * Receives effect from a shift ability.
   *
   */

  @Override
  public void receiveShiftEffect(Trainer trainer) {
    trainer.ShiftType();
  }

  @Override
  public IAbilities getAbility(int index){
    return abilities.get(index);
  }

  @Override
  public  List<IAbilities> getAbilityList(){
    return abilities;
  }


  @Override
  public void setAbilities(IAbilities abilities) {
    if (this.abilities.size() < 4) {
      this.abilities.add(abilities);
    }
  }



  //endregion
}