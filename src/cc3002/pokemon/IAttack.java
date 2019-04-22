package cc3002.pokemon;


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
}
