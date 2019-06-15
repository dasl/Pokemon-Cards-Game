package cc3002.pokemon.normal;

import cc3002.pokemon.Abilities.AbstractAttack;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a normal type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class NormalAttack extends AbstractAttack {

  /**
   * Creates a new attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  public NormalAttack(String name, int baseDamage,String text) {
    super(name, baseDamage,text);
  }

  /**
   * Performs a normal type attack.
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
