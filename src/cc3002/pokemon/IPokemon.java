package cc3002.pokemon;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;
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
/**
 *An interface was made with the main objective of being able to carry out a double dispatch and with this being able to apply the
 *properties of each attack and identify how the attack affects a receiving pokemon.
 *
 * @author Diego Sandoval Leiva
 */
public interface IPokemon extends ICard{

  //region Properties


    /**
   * @return Pokémon's name.
   */
  String getName();

  /**
   * @return Pokémon's fire energies
   */
  int getFireEnergies();

  /**
   * @return Pokémon's water energies
   */
  int getWaterEnergies();
  /**
   * @return Pokémon's electric energies
   */
  int getElectricEnergies();

  /**
   * @return Pokémon's grass energies
   */
  int getGrassEnergies();

  /**
   * @return Pokémon's normal energies
   */
  int getNormalEnergies();

  /**
   * @return Pokémon's psychic energies
   */
  int getPsychicEnergies();

  /**
   * @return Pokémon's hit points
   */
  int getHP();


    int getID();

    /**
   * Reset Pokémon's energies.
   */
  void resetEnergies();

  void receiveShiftEffect(Trainer trainer);

  IAbilities getAbility(int index);


  //endregion


  /**
   * Attacks another Pokémon.
   *
   * @param other Target of the attack.
   */
  void attack(IPokemon other);


    void selectAbility(int index);

    IAbilities getSelectedAbility();

    void useAbility(Trainer adversary);


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
   * @param energy Received energy.
   */
  void receiveWaterEnergy(WaterEnergy energy);

  /**
   * Receives an energy from a grass energy.
   *
   * @param energy Received energy.
   */
  void receiveGrassEnergy(GrassEnergy energy);

  /**
   * Receives an energy from a fire energy.
   *
   * @param energy Received energy.
   */
  void receiveFireEnergy(FireEnergy energy);

  /**
   * Receives an energy from a normal energy.
   *
   * @param energy Received energy.
   */
  void receiveNormalEnergy(NormalEnergy energy);

  /**
   * Receives an energy from a psychic energy.
   *
   * @param energy Received energy.
   */
  void receivePsychicEnergy(PsychicEnergy energy);

  /**
   * Receives an energy from a electric energy.
   *
   * @param energy Received energy.
   */
  void receiveElectricEnergy(ElectricEnergy energy);

  /**
   * Receives an energy.
   *
   * @param energy Receive energy.
   */
  void receiveEnergy(IEnergy energy);


  List<IAbilities> getAbilityList();

  void setAbilities(IAbilities abilities);

  void receiveAfterimageAssaultEffect(Trainer trainer);

  void getObjectType(Trainer trainer);

  void copyType(IPokemon pokemon, Trainer trainer);

  void sendTypeBEP(Trainer trainer);

  void sendTypeBFP(Trainer trainer);

  void sendTypeBNP(Trainer trainer);

  void sendTypeBWP(Trainer trainer);

  void sendType1FP(Trainer trainer);

  void sendType2FP(Trainer trainer);

  void sendTypeBGP(Trainer trainer);

  void sendType1GP(Trainer trainer);

  void sendType2GP(Trainer trainer);

  void sendType1NP(Trainer trainer);

  void sendType2NP(Trainer trainer);

  void sendTypeBPP(Trainer trainer);

  void sendType2PP(Trainer trainer);

  void sendType2WP(Trainer trainer);

  void sendType1EP(Trainer trainer);

  void sendType2EP(Trainer trainer);

  void sendType1PP(Trainer trainer);

  void sendType1WP(Trainer trainer);

}