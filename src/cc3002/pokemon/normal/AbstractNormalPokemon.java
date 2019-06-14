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
public abstract class AbstractNormalPokemon extends AbstractPokemon {

  /**
   * Creates a new normal Pokémon.
   *
   * @param name  Pokémon's name.
   * @param id Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param attackList  Pokémon's attacks.
   */
  protected AbstractNormalPokemon(String name,int id, int hp, List<IAttack> attackList) {
    super(name,id ,hp, attackList);
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
