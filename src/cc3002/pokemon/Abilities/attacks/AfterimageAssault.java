package cc3002.pokemon.Abilities.attacks;


import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.Trainer.Trainer;

/**
 * AfterimageAssault contains the required methods to use this ability.
 *
 * @author Diego Sandoval Leiva
 */

public class AfterimageAssault extends AbstractAttack {


    /**
     * Creates a new attack.
     *
     * @param name       Attack name
     * @param baseDamage Base damage of the attack
     * @param text
     * @param costs
     */
    public AfterimageAssault(String name, int baseDamage, String text, EnergyCounter costs) {
        super(name, baseDamage, text, costs);
    }

    @Override
    public void applyEffect(Trainer trainer){
        trainer.getActivePokemon().receiveAfterimageAssaultEffect(trainer);
        trainer.getActivePokemon().attack(trainer.getOponent().getActivePokemon());
    }

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveAIAAttack(this);
    }
}
