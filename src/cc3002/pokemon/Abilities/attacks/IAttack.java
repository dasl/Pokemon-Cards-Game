package cc3002.pokemon.Abilities.attacks;


import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
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
 * @author Diego Sandoval Leiva
 */
public interface IAttack extends IAbilities {

  /**
   * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
   * Pokémon that receives the attack.
   *
   * @param other Pokémon that receives the attack.
   */
  void attack(IPokemon other);


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

  /**
   * Getter for the attack's text.
   *
   * @return text of the attack.
   */
  String getText();

}
