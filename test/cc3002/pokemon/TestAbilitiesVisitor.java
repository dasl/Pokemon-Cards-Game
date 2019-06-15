package cc3002.pokemon;
import cc3002.pokemon.Abilities.AttackVisitor;
import cc3002.pokemon.Abilities.ConcreteIAbilityVisitor;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.WingBuzz;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.water.BasicWP;
import static org.junit.Assert.*;

import cc3002.pokemon.water.WaterAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestAbilitiesVisitor {
    private IPokemon charmander,totodile;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, WingBuzz,waterAttack;

    @Before
    public void setUp() {
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.");
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
        WingBuzz = new WingBuzz("WingBuzz","Soy entero pulento");

        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(WingBuzz,fireAttack)));
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>(Arrays.asList(WingBuzz,waterAttack)));
        Brook = new Trainer("Brook",totodile,new ArrayList<>());
        Ash = new Trainer("Ash",charmander,new ArrayList<>());

    }

    @Test
    public void DameError(){
        Ash.getActivePokemon().selectAbility(1); // Ataque
        Ash.getActivePokemon().useAbility(Brook);
        assertEquals(Brook.getActivePokemon().getHP(),60);

        Brook.getActivePokemon().selectAbility(1); // Ataque
        Brook.getActivePokemon().useAbility(Ash);
        assertEquals(Ash.getActivePokemon().getHP(),0);
    }


}
