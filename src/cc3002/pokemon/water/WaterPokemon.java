package cc3002.pokemon.water;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a water type Pokémon.
 *
 * @author Ignacio Slater Muñoz
 */
public class WaterPokemon extends AbstractPokemon {

  /**
   * Creates a new water Pokémon.
   *
   * @param name  Pokémon's name.
   * @param hp  Pokémon's hit points.
   * @param attackList  Pokémon's attacks.
   */
  public WaterPokemon(String name, int hp, List<IAttack> attackList) {
    super(name, hp, attackList);
  }

  public void receiveWaterEnergy(WaterEnergy energy) { receiveEnergy(energy); }
  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveResistantAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveFireAttack(FireAttack attack) {
    receiveResistantAttack(attack);
  }
}
