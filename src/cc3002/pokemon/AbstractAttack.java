package cc3002.pokemon;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and base damage.
 *
 * @author Ignacio Slater Muñoz
 */
public abstract class AbstractAttack implements IAttack {

  private int baseDamage;
  private String name;

  /**
   * Creates a new attack.
   *
   * @param name Attack name
   * @param baseDamage Base damage of the attack
   */
  protected AbstractAttack(String name, int baseDamage) {
    this.baseDamage = baseDamage;
    this.name = name;
  }

  //region Properties
  @Override
  public int getBaseDamage() {
    return baseDamage;
  }

  @Override
  public String getName() {
    return name;
  }
  //endregion

  /**
   * Checks if this attack is equal to another.
   *
   * @param obj Object to compare this attack.
   * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
        && ((IAttack) obj).getName().equals(name);
  }
}
