package cc3002.pokemon;

import cc3002.pokemon.Abilities.*;
import cc3002.pokemon.Abilities.attacks.ElectricShock;
import cc3002.pokemon.Abilities.attacks.IAttack;
import cc3002.pokemon.Abilities.visitor.AttackVisitor;
import cc3002.pokemon.Abilities.visitor.ConcreteIAbilityVisitor;
import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.*;
import cc3002.pokemon.fire.*;
import cc3002.pokemon.grass.*;
import cc3002.pokemon.normal.*;
import cc3002.pokemon.psychic.*;
import cc3002.pokemon.water.*;

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
  private IPokemon clonetype;
  private EnergyCounter energies;

  /**
   * Creates a new Pokémon.
   *
   * @param name  Pokémon's name.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's abilities. // grass, fire, water, electric, normal, psychic
   */
  protected AbstractPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
    this.typeCard = "Pokemon";
    this.name = name;
    this.id = id;
    this.hp = hp;
    this.abilities = abilitiesList;
    this.energies = new EnergyCounter();
  }

  /**
   * Accept card visitor
   *
   */
  @Override
  public void accept(ICardVisitor visitor){
    visitor.visitPokemonCard(this);
  }

  /**
   * Play this pokemon card.
   */
  @Override
  public void play(){
    getTrainer().setSelectedPokemon(this);
    getTrainer().addPokemonToBench(getTrainer().getSelectedPokemon());
  }

  /**
   * Receives an energy from a water energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveWaterEnergy(WaterEnergy energy) { this.energies.setWaterEnergy();}


  /**
   * Receives an energy from a grass energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveGrassEnergy(GrassEnergy energy) {this.energies.setGrassEnergy();}

  /**
   * Receives an energy from a fire energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveFireEnergy(FireEnergy energy) { this.energies.setFireEnergy();}


  /**
   * Receives an energy from a normal energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receiveNormalEnergy(NormalEnergy energy) {this.energies.setNormalEnergy();}

  /**
   * Receives an energy from a psychic energy.
   *
   * @param energy Received energy.
   */
  @Override
  public void receivePsychicEnergy(PsychicEnergy energy) {this.energies.setPsychicEnergy();}


  /**
   * Receives an energy from a electric energy.
   *
   * @param energy Received energy.
   */
  public void receiveElectricEnergy(ElectricEnergy energy) {this.energies.setElectricEnergy();}


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
  public void receiveWaterAttack(WaterAttack attack) { receiveAttack(attack); }
  /**
   * Receives damage from a Grass attack.
   *
   * @param attack Received attack.
   */
  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveAttack(attack);
  }

  /**
   * Receives damage from a ExtraElectricShock attack.
   *
   * @param electricShock Received attack.
   */
  @Override
  public void receiveExtraElectricShockAttack(ElectricShock electricShock) {
    receiveExtraAttack();
  }

  /**
   * Receives damage from a ExtraElectricShock attack.
   *
   * @param electricShock Received attack.
   */
  @Override
  public void receiveElectricShockAttack(ElectricShock electricShock) {
    receiveAttack(electricShock);
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
   * Receives an attack.
   */
  protected void receiveExtraAttack() {
    this.hp -= 20;
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
    return this.energies.getFireEnergy();
  }

  @Override
  public int getWaterEnergies() {
    return this.energies.getWaterEnergy();
  }

  @Override
  public int getElectricEnergies() {
    return this.energies.getElectricEnergy();
  }

  @Override
  public int getGrassEnergies() {
    return this.energies.getGrassEnergy();
  }

  @Override
  public int getNormalEnergies() {
    return this.energies.getNormalEnergy();
  }

  @Override
  public int getPsychicEnergies() {
    return this.energies.getPyshicEnergy();
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
    this.energies.clear();
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
      attackVisitor.getAttack().attack(adversary.getActivePokemon());
    }
  }





  /**
   * Getter of ability by id.
   *
   * @param index
   * @return ability
   */
  @Override
  public IAbilities getAbility(int index){
    return abilities.get(index);
  }


  /**
   * Getter of abilities.
   *
   * @return abilities
   */
  @Override
  public  List<IAbilities> getAbilityList(){
    return abilities;
  }


  /**
   * Setter of ability by ability.
   *
   * @param abilities
   */
  @Override
  public void setAbilities(IAbilities abilities) {
    if (this.abilities.size() < 4) {
      this.abilities.add(abilities);
    }
  }




  //endregion
}