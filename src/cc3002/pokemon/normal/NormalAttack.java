package cc3002.pokemon.normal;

import cc3002.pokemon.AbstractAttack;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a normal type attack.
 *
 * @author Ignacio Slater Muñoz
 */
public class NormalAttack extends AbstractAttack {

  /**
   * Creates a new attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  public NormalAttack(String name, int baseDamage) {
    super(name, baseDamage);
  }

  /**
   * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
   * Pokémon that receives the attack.
   *
   * @param other Pokémon that receives the attack.
   */
  @Override
  public void attack(IPokemon other) {
    other.receiveNormalAttack(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof NormalAttack && super.equals(obj);
  }
}
