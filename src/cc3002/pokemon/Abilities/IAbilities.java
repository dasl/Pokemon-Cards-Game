package cc3002.pokemon.Abilities;

import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.Trainer.Trainer;

public interface IAbilities{
    void accept(IAbilityVisitor visitor);
    String getName();


    /**
     * Add an effect to an abstractPokemon
     * This is the handshake of the double dispatch
     *
     * @param abstractPokemon
     */
    void applyEffect(Trainer abstractPokemon);

    int getBaseDamage();
}
