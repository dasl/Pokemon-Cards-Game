package cc3002.pokemon.water;

import cc3002.pokemon.Abilities.AbstractAttack;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a water type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class WaterAttack extends AbstractAttack {

  /**
   * Creates a new water type attack.
   * {@inheritDoc}
   *
   * @param name Attack's name.
   * @param baseDamage Attack's base damage.
   */
  public WaterAttack(String name, int baseDamage,String text) {
    super(name, baseDamage,text);
  }
  /**
   * Performs a water type attack.
   *
   * @param other Pokémon that receives the attack.
   */
  @Override
  public void attack(IPokemon other) {
    other.receiveWaterAttack(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof WaterAttack && super.equals(obj);
  }
}
