package cc3002.pokemon.fire;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.water.WaterAttack;
import java.util.List;

/**
 * Class that represents a fire type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractFirePokemon extends AbstractPokemon{


  /**
   * Creates a new Fire Pokémon.
   *  @param name  Pokémon's name.
   * @param id Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's attacks.
   */

  protected AbstractFirePokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
    super(name,id, hp, abilitiesList);
  }


  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveWeaknessAttack(attack);
  }

}
