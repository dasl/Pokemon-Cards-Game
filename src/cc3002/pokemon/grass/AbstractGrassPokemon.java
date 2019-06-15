package cc3002.pokemon.grass;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.water.WaterAttack;
import java.util.List;


/**
 * Class that represents a Grass type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractGrassPokemon extends AbstractPokemon {

  /**
   * Creates a new grass Pokémon.
   *  @param name  Pokémon's name.
   * @param id Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's attacks.
   */
  protected AbstractGrassPokemon(String name , int id, int hp, List<IAbilities> abilitiesList) {
    super(name,id, hp, abilitiesList);
  }

  @Override
  public void receiveWaterAttack(WaterAttack attack) {
    receiveResistantAttack(attack);
  }

  @Override
  public void receiveFireAttack(FireAttack attack) {
    receiveWeaknessAttack(attack);
  }
}
