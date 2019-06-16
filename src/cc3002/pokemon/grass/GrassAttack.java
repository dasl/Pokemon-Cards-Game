package cc3002.pokemon.grass;

import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a grass type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassAttack extends AbstractAttack {


  /**
   * Creates a new attack.
   *
   * @param name       Attack name
   * @param baseDamage Base damage of the attack
   * @param text
   * @param costs
   */
  public GrassAttack(String name, int baseDamage, String text, EnergyCounter costs) {
    super(name, baseDamage, text, costs);
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
