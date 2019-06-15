package cc3002.pokemon.Abilities;

public interface IAbilities{
    void accept(IAbilityVisitor IAbilityVisitor);

    String getName();
}
