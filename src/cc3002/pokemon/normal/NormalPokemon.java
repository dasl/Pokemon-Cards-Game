package cc3002.pokemon.normal;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class that represents a Normal type Pokémon.
 *
 * @author Diego Sandovcal Leiva
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
  public void receivePsychicAttack(PsychicAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveWeaknessAttack(attack);
  }

}
