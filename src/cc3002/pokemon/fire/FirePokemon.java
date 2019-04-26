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
 * @author Ignacio Slater Muñoz
 */
public class FirePokemon extends AbstractPokemon{


  public FirePokemon(String name, int hp, List<IAttack> attackList) {
    super(name, hp, attackList);
  }


  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveResistantAttack(attack);
  }

  @Override
  public void receiveFireAttack(FireAttack attack) {
    receiveResistantAttack(attack);
  }
}
