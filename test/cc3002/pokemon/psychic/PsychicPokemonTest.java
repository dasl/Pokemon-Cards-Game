package cc3002.pokemon.psychic;

import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.ElectricAttack;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.water.WaterAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PsychicPokemonTest {
    private IPokemon
            charmander,
            abra;
    private FireAttack fireAttack;
    private GrassAttack grassAttack;
    private NormalAttack normalAttack;
    private WaterAttack waterAttack;
    private PsychicAttack psychicAttack;
    private ElectricAttack electricAttack;

    @Before
    public void setUp() {
        psychicAttack = new PsychicAttack("Confusion", 50);
        fireAttack = new FireAttack("Ember", 40);
        grassAttack = new GrassAttack("Vine Whip", 45);
        normalAttack = new NormalAttack("Pound", 40);
        waterAttack = new WaterAttack("Bubble", 40);
        electricAttack = new ElectricAttack("Thunder Shock",30);
        charmander = new FirePokemon("Charmander", 100, new ArrayList<>());
        abra = new PsychicPokemon("Abra", 100,
                new ArrayList<>(Arrays.asList(psychicAttack, normalAttack)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Abra", abra.getName());
        assertEquals(100, abra.getHP());
        assertEquals(2, abra.getAttacks().size());
        assertEquals(psychicAttack, abra.getAttacks().get(0));
        assertEquals(normalAttack, abra.getAttacks().get(1));
        assertNull(abra.getSelectedAttack());
    }

    @Test
    public void selectAttackTest() {
        abra.selectAttack(0);
        assertEquals(psychicAttack, abra.getSelectedAttack());
        abra.selectAttack(1);
        assertEquals(normalAttack, abra.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        abra.selectAttack(0);
        abra.attack(charmander);
        assertEquals(50, charmander.getHP());
    }

    @Test
    public void receiveWaterAttack() {
        assertEquals(100,abra.getHP());
        abra.receiveWaterAttack(waterAttack);
        assertEquals(60, abra.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveGrassAttack(grassAttack);
        assertEquals(55, abra.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveFireAttack(fireAttack);
        assertEquals(60, abra.getHP());
    }

    @Test
    public void receiveNormalAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveNormalAttack(normalAttack);
        assertEquals(90, abra.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, abra.getHP());
        abra.receiveElectricAttack(electricAttack);
        assertEquals(70, abra.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, abra.getHP());
        abra.receivePsychicAttack(psychicAttack);
        assertEquals(0, abra.getHP());
    }

}