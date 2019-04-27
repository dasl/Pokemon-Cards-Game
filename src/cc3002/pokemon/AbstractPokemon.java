package cc3002.pokemon;

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
public abstract class AbstractPokemon implements IPokemon {
  private String typeCard;
  private String name;
  private int hp;
  private List<IAttack> attackList;
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
   * @param attackList  Pokémon's attacks.
   */
  protected AbstractPokemon(String name, int hp, List<IAttack> attackList) {
    this.typeCard = "Pokemon";
    this.name = name;
    this.hp = hp;
    this.attackList = attackList;
    this.waterEnergies = new ArrayList<>();
    this.fireEnergies = new ArrayList<>();
    this.electricEnergies = new ArrayList<>();
    this.grassEnergies = new ArrayList<>();
    this.psychicEnergies = new ArrayList<>();
    this.normalEnergies = new ArrayList<>();
  }

    @Override
    public void receiveWaterEnergy(WaterEnergy energy) { this.waterEnergies.add(energy);}

    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {this.grassEnergies.add(energy);}

    @Override
    public void receiveFireEnergy(FireEnergy energy) { this.fireEnergies.add(energy);}

    @Override
    public void receiveNormalEnergy(NormalEnergy energy) {this.normalEnergies.add(energy);}

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {this.psychicEnergies.add(energy);}

    @Override
    public void receiveElectricEnergy(ElectricEnergy energy) {this.electricEnergies.add(energy);}

    public void receiveEnergy(IEnergy energy){
      energy.addToPoke(this);
    }

    @Override
    public void selectAttack(int index) {
    selectedAttack = attackList.get(index);
  }

  @Override
  public void attack(IPokemon other) {
    selectedAttack.attack(other);
  }

  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveAttack(attack);
  }

  @Override
  public void receiveFireAttack(FireAttack attack) {
    receiveAttack(attack);
  }

  @Override
  public void receiveNormalAttack(NormalAttack attack) {
    receiveAttack(attack);
  }

  @Override
  public void receivePsychicAttack(PsychicAttack attack) {
    receiveAttack(attack);
  }

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
  public List<IAttack> getAttackList(){
    return this.attackList;
  }


  @Override
  public int getHP() {
    return hp;
  }

  @Override
  public List<IAttack> getAttacks() {
    return attackList;
  }

  @Override
  public IAttack getSelectedAttack() {
    return selectedAttack;
  }


  @Override
  public void setAttacks(IAttack attack){
    this.attackList.add(attack);
  }
  //endregion
}