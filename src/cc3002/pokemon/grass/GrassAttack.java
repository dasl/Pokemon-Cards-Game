package cc3002.pokemon.grass;

import cc3002.pokemon.AbstractAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.water.WaterAttack;

/**
 * This class defines the logic of a grass type attack.
 *
 * @author Ignacio Slater Muñoz
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
   * {@inheritDoc}
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
