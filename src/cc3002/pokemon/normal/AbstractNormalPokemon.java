package cc3002.pokemon.normal;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.psychic.PsychicAttack;

import java.util.List;

/**
 * Class that represents a Normal type Pokémon.
 *
 * @author Diego Sandovcal Leiva
 */
public abstract class AbstractNormalPokemon extends AbstractPokemon {

  /**
   * Creates a new normal Pokémon.
   *  @param name  Pokémon's name.
   * @param id Pokémon's id.
   * @param hp  Pokémon's hit points.
   * @param abilitiesList  Pokémon's attacks.
   */
  protected AbstractNormalPokemon(String name, int id, int hp, List<IAbilities> abilitiesList) {
    super(name,id ,hp, abilitiesList);
  }
  @Override
  public void receivePsychicAttack(PsychicAttack attack) {
    receiveWeaknessAttack(attack);
  }

  @Override
  public void receiveGrassAttack(GrassAttack attack) {
    receiveWeaknessAttack(attack);
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
    else if (!(o instanceof AbstractNormalPokemon)) return false;
    else return false;
  }
}
