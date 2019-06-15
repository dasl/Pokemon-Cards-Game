package cc3002.pokemon.grass;

import cc3002.pokemon.Abilities.AbstractAttack;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a grass type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassAttack extends AbstractAttack {

  /**
   * Creates a new grass type attack.
   *  @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  public GrassAttack(String name, int baseDamage,String text) {
    super(name, baseDamage,text);
  }

  /**
   * Performs a grass type attack.
   *
   * @param other Pokémon that receives the attack.
   */
  @Override
  public void attack(IPokemon other) {
    other.receiveGrassAttack(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof GrassAttack && super.equals(obj);
  }
}
