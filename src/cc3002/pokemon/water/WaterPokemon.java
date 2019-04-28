package cc3002.pokemon.water;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a water type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public class WaterPokemon extends AbstractPokemon {

  /**
   * Creates a new water Pokémon.
   *
   * @param name  Pokémon's name.
   * @param id  Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param attackList  Pokémon's attacks.
   */
  public WaterPokemon(String name,int id,int hp, List<IAttack> attackList) {
    super(name, id,hp, attackList);
  }

  @Override
  public void receiveElectricAttack(ElectricAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveNormalAttack(NormalAttack attack) {
    receiveResistantAttack(attack);
  }
}
