package cc3002.pokemon.psychic;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests set for the Psychic class.
 *
 * @author Diego Sandoval Leiva
 */

public class PsychicAttackTest {

    private IAttack psyshicAttack;
    private IPokemon
            slowpoke,
            mew,
            kadabra,
            abra,
            charmander,
            treecko,
            totodile,
            audino;

    @Before
    public void setUp() throws Exception {
        psyshicAttack = new PsychicAttack("Confusion", 50);
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Confusion", psyshicAttack.getName());
        assertEquals(50, psyshicAttack.getBaseDamage());
    }

    @Test
    public void attackTest() {
        psyshicAttack.attack(charmander);
        psyshicAttack.attack(treecko);
        psyshicAttack.attack(totodile);
        psyshicAttack.attack(audino);

        assertEquals(50, charmander.getHP());
        assertEquals(50, treecko.getHP());
        assertEquals(50, totodile.getHP());
        assertEquals(0, audino.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(psyshicAttack, new PsychicAttack("Confusion", 50));
        assertNotEquals(psyshicAttack, new WaterAttack("Bubble", 30));
        assertNotEquals(psyshicAttack, new WaterAttack("Not Bubble", 40));
        assertNotEquals(psyshicAttack, new FireAttack("Bubble", 40));
    }
}