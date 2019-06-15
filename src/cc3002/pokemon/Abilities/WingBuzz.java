package cc3002.pokemon.Abilities;

import cc3002.pokemon.IPokemon;

/**
 * Wing Buzz: Una vez por turno, si éste Pokémon es el activo, puedes descartar una carta de
 * tu mano. Si lo haces, descarta la carta superior del mazo de tu oponente
 *
 * @author Diego Sandoval Leiva
 */

public class WingBuzz extends AbstractAbilities{

    public WingBuzz(String name, String text) {
        super(name, text);
    }

    /**
     * Active the ability on the active pokemon
     *
     * @param name Attack name
     */
    public void activeWingBuzz(IPokemon activepokemon){

    }
}
