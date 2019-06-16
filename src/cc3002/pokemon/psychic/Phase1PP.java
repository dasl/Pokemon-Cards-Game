package cc3002.pokemon.psychic;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Trainer.Trainer;

import java.util.List;

public class Phase1PP extends AbstractPsychicPokemon implements IPsychicPokemon{
    /**
     * Creates a new electric Pokémon.
     *  @param name       Pokémon's name.
     * @param id         Pokémon's id.
     * @param hp         Pokémon's hit points.
     * @param abilitiesList Pokémon's attacks.
     */
    public Phase1PP(String name, int id, int hp, List<IAbilities> abilitiesList) {
        super(name, id, hp, abilitiesList);
    }

    @Override
    public void getObjectType(Trainer trainer) {
        trainer.getActivePokemon().sendType1PP(trainer);
    }
}
