package cc3002.pokemon.fire;

import cc3002.pokemon.Abilities.attacks.AbstractAttack;

import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a fire type attack.
 *
 * @author Diego Sandoval Leiva
 */
public class FireAttack extends AbstractAttack {


  /**
   * Creates a new attack.
   *
   * @param name       Attack name
   * @param baseDamage Base damage of the attack
   * @param text
   * @param costs
   */
  public FireAttack(String name, int baseDamage, String text, EnergyCounter costs) {
    super(name, baseDamage, text, costs);
  }

  /**
   * Performs a fire type attack.
   *
   * @param other Pokémon that receives the attack.
   */
  @Override
  public void attack(IPokemon other) {
    other.receiveFireAttack(this);
  }



  @Override
  public boolean equals(Object obj) {
    return obj instanceof FireAttack && super.equals(obj);
  }




}