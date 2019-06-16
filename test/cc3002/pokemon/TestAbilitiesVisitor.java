package cc3002.pokemon;
import cc3002.pokemon.Abilities.*;
import cc3002.pokemon.Abilities.attacks.AfterimageAssault;
import cc3002.pokemon.Abilities.otherAbilities.Shift;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.normal.BasicNP;
import cc3002.pokemon.water.BasicWP;
import static org.junit.Assert.*;

import cc3002.pokemon.water.WaterAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestAbilitiesVisitor {
    private IPokemon charmander,totodile,audino;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, shift,waterAttack,afterimageassault;

    @Before
    public void setUp() {
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.");
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.");
        afterimageassault = new AfterimageAssault("AfterimageAssault", 40,"An attack that may inflict a burn.");
        shift = new Shift("Shift","Soy entero pulento");

        // Pokemons
        audino = new BasicNP("Audino",1, 100, new ArrayList<>());
        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(shift,fireAttack,afterimageassault)));
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>(Arrays.asList(shift,waterAttack)));

        // Trainers
        Brook = new Trainer("Brook",totodile,new ArrayList<>(Arrays.asList(audino)));
        Ash = new Trainer("Ash",charmander,new ArrayList<>(Arrays.asList(audino)));

    }

    @Test
    public void AttackVisitorTest(){
        Ash.selectAbility(1); // Ataque
        Ash.useAbility(Brook);
        assertEquals(Brook.getActivePokemon().getHP(),60);

        Brook.getActivePokemon().selectAbility(1); // Ataque
        Brook.getActivePokemon().useAbility(Ash);
        assertEquals(Ash.getActivePokemon().getHP(),0);
    }

    @Test
    public void ConcreteAbilityVisitorTest(){

        Ash.selectAbility(0); // Habilidad: Shift
        Ash.setPokemonType(audino); // Seteo el tipo de audino.
        Ash.useAbility(Brook); // Ejecuto la habilidad.
/*        System.out.println(Ash.getActivePokemon().getClass());
        System.out.println(Brook.getActivePokemon().getClass());*/
    }

    @Test
    public void AfterimageAssaultTest(){
        Ash.addPokemonToDeck(charmander);
        Ash.addPokemonToDeck(charmander);
        Ash.selectAbility(2);
        Ash.useAbility(Brook);
        assertEquals(Ash.getBench().size(),3);


    }


}
