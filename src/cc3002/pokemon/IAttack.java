package cc3002.pokemon;


import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

/**
 * Common interface for all the attacks. Every attack have a name and a base damage, and should be
 * able to damage a Pokémon.
 *
 * @author Ignacio Slater Muñoz
 */
public interface IAttack {

  /**
   * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
   * Pokémon that receives the attack.
   *
   * @param other Pokémon that receives the attack.
   */
  void attack(IPokemon other);




  void setFireRequiredEnergies(FireEnergy energy);

  void setWaterRequiredEnergies(WaterEnergy energy);

  void setElectricRequiredEnergies(ElectricEnergy energy);

  void setPsychicRequiredEnergies(PsychicEnergy energy);

  void setGrassRequiredEnergies(GrassEnergy energy);

  void setNormalRequiredEnergies(NormalEnergy energy);

  /**
   * Getter for the base damage.
   *
   * @return Base damage of the attack.
   */
  int getBaseDamage();

  /**
   * Getter for the attack's name.
   *
   * @return Name of the attack.
   */
  String getName();


  int getFireRequiredEnergies();

  int getGrassRequiredEnergies();

  int getElectricRequiredEnergies();

  int getNormalRequiredEnergies();

  int getWaterRequiredEnergies();

  int getPsychicRequiredEnergies();
}
