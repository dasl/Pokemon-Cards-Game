package cc3002.pokemon.Visitor;

import cc3002.pokemon.electric.AbstractElectricPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.normal.AbstractNormalPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

public interface IPokemonVisitor {
    void visitPsychicPokemon(AbstractPsychicPokemon psychicPokemon);
    void visitFirePokemon(AbstractFirePokemon firePokemon);
    void visitNormalPokemon(AbstractNormalPokemon normalPokemon);
    void visitElectricPokemon(AbstractElectricPokemon electricPokemon);
    void visitWaterPokemon(AbstractWaterPokemon waterPokemon);
    void visitGrassPokemon(AbstractGrassPokemon grassPokemon);
}
