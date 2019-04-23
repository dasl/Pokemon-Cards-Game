package cc3002.pokemon;

import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;

import java.util.List;

public interface IPokemon{

  //region Properties

  /**
   * @return Pokémon's name.
   */
  String getName();

  /**
   * @return Pokémon's hit points
   */
  int getHP();
  /**
   * @return Energies with all the Pokémon attacks.
   */
  int getEnergies();
  /**
   * @return List with all the Pokémon attacks.
   */
  List<IAttack> getAttacks();

  /**
   * @return The current selected attack.
   */
  IAttack getSelectedAttack();
  //endregion

  /**
   * Attacks another Pokémon.
   *
   * @param other Target of the attack.
   */
  void attack(IPokemon other);

  /**
   * Selects an attack.
   *
   * @param index Index of the attack to be selected.
   */
  void selectAttack(int index);

  /**
   * Receives damage from a water attack.
   *
   * @param attack Received attack.
   */
  void receiveWaterAttack(WaterAttack attack);

  /**
   * Receives damage from a grass attack.
   *
   * @param attack Received attack.
   */
  void receiveGrassAttack(GrassAttack attack);

  /**
   * Receives damage from a fire attack.
   *
   * @param attack Received attack.
   */
  void receiveFireAttack(FireAttack attack);

  /**
   * Receives damage from a normal attack.
   *
   * @param attack Received attack.
   */
  void receiveNormalAttack(NormalAttack attack);

  /**
   * Receives damage from a psychic attack.
   *
   * @param attack Received attack.
   */
  void receivePsychicAttack(PsychicAttack attack);

  /**
   * Receives damage from a electric attack.
   *
   * @param attack Received attack.
   */
  void receiveElectricAttack(ElectricAttack attack);

  /**
   * Receives an energy from a water energy.
   *
   * @param energy Received attack.
   */
  void receiveWaterEnergy(WaterEnergy energy);

  /**
   * Receives an energy from a grass energy.
   *
   * @param energy Received attack.
   */
  void receiveGrassEnergy(GrassEnergy energy);

  /**
   * Receives an energy from a fire energy.
   *
   * @param energy Received attack.
   */
  void receiveFireEnergy(FireEnergy energy);

  /**
   * Receives an energy from a normal energy.
   *
   * @param energy Received attack.
   */
  void receiveNormalEnergy(NormalEnergy energy);

  /**
   * Receives an energy from a psychic energy.
   *
   * @param energy Received attack.
   */
  void receivePsychicEnergy(PsychicEnergy energy);

  /**
   * Receives an energy from a electric energy.
   *
   * @param energy Received attack.
   */
  void receiveElectricEnergy(ElectricEnergy energy);


}