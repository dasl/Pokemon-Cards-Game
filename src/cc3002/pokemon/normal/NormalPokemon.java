package cc3002.pokemon.normal;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a normal type Pokémon.
 *
 * @author Ignacio Slater Muñoz
 */
public class NormalPokemon extends AbstractPokemon {

  /**
   * Creates a new normal Pokémon.
   *
   * @param name  Pokémon's name.
   * @param hp  Pokémon's hit points.
   * @param attackList  Pokémon's attacks.
   */
  public NormalPokemon(String name, int hp, List<IAttack> attackList) {
    super(name, hp, attackList);
  }
  @Override
  public void receiveNormalEnergy(NormalEnergy energy) { receiveEnergy(energy);}
}
