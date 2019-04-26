package cc3002.pokemon.electric;

import cc3002.pokemon.IAttack;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ElectricAttackTest {
    private IAttack electricAttack;
    private IPokemon
            slowpoke,
            mew,
            kadabra,
            abra,
            charmander,
            pikachu,
            treecko,
            totodile,
            audino;

    @Before
    public void setUp() throws Exception {
        electricAttack = new ElectricAttack("Thunder Shock",30);
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        treecko = new GrassPokemon("Treecko", 100, new ArrayList<>());
        totodile = new WaterPokemon("Totodile", 100, new ArrayList<>());
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu", 100, new ArrayList<>());
    }

    @Test
    public void constructorTest() {
        assertEquals("Thunder Shock", electricAttack.getName());
        assertEquals(30, electricAttack.getBaseDamage());
    }

    @Test
    public void attackTest() {
        electricAttack.attack(charmander);
        electricAttack.attack(treecko);
        electricAttack.attack(totodile);
        electricAttack.attack(audino);

        assertEquals(70, charmander.getHP());
        assertEquals(70, treecko.getHP());
        assertEquals(40, totodile.getHP());
        assertEquals(70, audino.getHP());
    }

    @Test
    public void equalsTest() {
        assertEquals(electricAttack, new ElectricAttack("Thunder Shock", 30));
        assertNotEquals(electricAttack, new WaterAttack("Bubble", 30));
        assertNotEquals(electricAttack, new WaterAttack("Not Bubble", 40));
        assertNotEquals(electricAttack, new FireAttack("Bubble", 40));
    }

}