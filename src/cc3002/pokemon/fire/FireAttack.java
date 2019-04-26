package cc3002.pokemon.fire;

import cc3002.pokemon.AbstractAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

/**
 * This class defines the logic of a fire type attack.
 *
 * @author Ignacio Slater Muñoz
 */
public class FireAttack extends AbstractAttack {

  /**
   * Creates a new fire type attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  public FireAttack(String name, int baseDamage) {
    super(name, baseDamage);
  }

  /**
   * Performs a fire type attack.
   * {@inheritDoc}
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