package cc3002.pokemon.fire;

import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IAttack;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.List;

/**
 * Class that represents a fire type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public class FirePokemon extends AbstractPokemon{


  /**
   * Creates a new Fire Pokémon.
   *
   * @param name  Pokémon's name.
   * @param id Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param attackList  Pokémon's attacks.
   */

  public FirePokemon(String name,int id, int hp, List<IAttack> attackList) {
    super(name,id, hp, attackList);
  }


  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveWeaknessAttack(attack);
  }

}
