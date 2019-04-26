package cc3002.pokemon.electric;

import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassAttack;
import cc3002.pokemon.normal.NormalAttack;
import cc3002.pokemon.normal.NormalPokemon;
import cc3002.pokemon.psychic.PsychicAttack;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ElectricPokemonTest {

    private IPokemon
            audino,
            pikachu,
            charmander;
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
        audino = new NormalPokemon("Audino", 100, new ArrayList<>());
        pikachu = new ElectricPokemon("Pikachu", 100,
                new ArrayList<>(Arrays.asList(electricAttack, normalAttack)));
    }

    @Test
    public void constructorTest() {
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(100, pikachu.getHP());
        assertEquals(2, pikachu.getAttacks().size());
        assertEquals(electricAttack, pikachu.getAttacks().get(0));
        assertEquals(normalAttack, pikachu.getAttacks().get(1));
        assertNull(pikachu.getSelectedAttack());
    }

    @Test
    public void selectAttackTest() {
        pikachu.selectAttack(0);
        assertEquals(electricAttack, pikachu.getSelectedAttack());
        pikachu.selectAttack(1);
        assertEquals(normalAttack, pikachu.getSelectedAttack());
    }

    @Test
    public void attackTest() {
        pikachu.selectAttack(0);
        pikachu.attack(audino);
        assertEquals(70, audino.getHP());
    }


    @Test
    public void receiveWaterAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveWaterAttack(waterAttack);
        assertEquals(60, pikachu.getHP());
    }

    @Test
    public void receiveGrassAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveGrassAttack(grassAttack);
        assertEquals(55, pikachu.getHP());
    }

    @Test
    public void receiveFireAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveFireAttack(fireAttack);
        assertEquals(60, pikachu.getHP());
    }

    @Test
    public void receiveNormalAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveNormalAttack(normalAttack);
        assertEquals(20, pikachu.getHP());
    }

    @Test
    public void receiveElectricAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receiveElectricAttack(electricAttack);
        assertEquals(70, pikachu.getHP());
    }

    @Test
    public void receivePsychicAttack() {
        assertEquals(100, pikachu.getHP());
        pikachu.receivePsychicAttack(psychicAttack);
        assertEquals(50, pikachu.getHP());
    }

}