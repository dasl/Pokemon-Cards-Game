package cc3002.pokemon.water;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import java.util.List;

/**
 * Class that represents a water type Pokémon.
 *
 * @author Diego Sandoval Leiva
 */
public abstract class AbstractWaterPokemon extends AbstractPokemon {

  /**
   * Creates a new water Pokémon.
   *  @param name  Pokémon's name.
   * @param id  Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's attacks.
   */
  protected AbstractWaterPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
    super(name, id,hp, abilitiesList);
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

  /**
   * Cheacks equals type (ONLY TYPE)
   *
   * @param o The target Pokemon object
   * @return True if are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    else if (!(o instanceof AbstractWaterPokemon)) return false;
    else return false;
  }
}
