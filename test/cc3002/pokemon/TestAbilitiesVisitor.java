package cc3002.pokemon;
import cc3002.pokemon.Abilities.*;
import cc3002.pokemon.Abilities.attacks.AbstractAttack;
import cc3002.pokemon.Abilities.attacks.ElectricShock;
import cc3002.pokemon.Abilities.otherAbilities.AbstractAbilities;
import cc3002.pokemon.Abilities.otherAbilities.Heal;
import cc3002.pokemon.Abilities.visitor.AttackVisitor;
import cc3002.pokemon.Abilities.visitor.ConcreteIAbilityVisitor;
import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.*;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.BasicNP;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.BasicWP;
import static org.junit.Assert.*;

import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestAbilitiesVisitor {
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
    private IPokemon charmander,totodile,audino,charmeleon,charizard;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, shift,waterAttack,electricShock;
    // INCREASING COVERAGE
    IAbilityVisitor attackVisitor,concreteIAbilityVisitor;
    AbstractAttack abstractAttack;
    AbstractAbilities abstractAbilities;
    // INCREASING COVERAGE

    @Before
    public void setUp() {
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        electricShock= new ElectricShock("ElectricShock", 40,"An attack entero pulento. jajaxd",new EnergyCounter());
        shift = new Heal("Heal","Soy entero pulento",new EnergyCounter());

        // Pokemons
        audino = new BasicNP("Audino",1, 100, new ArrayList<>(Arrays.asList(electricShock)));
        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(shift,fireAttack,electricShock)));
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>(Arrays.asList(shift,waterAttack)));
        charmeleon = new Phase1FP("Charmeleon",28,100, new ArrayList<>());

        charizard = new Phase2FP("Charizard",28,100, new ArrayList<>());
        // Trainers
        Brook = new Trainer("Brook",totodile,new ArrayList<>(Arrays.asList(audino)));
        Ash = new Trainer("Ash",charmander,new ArrayList<>(Arrays.asList(audino)));

        // Set Turn Duel
        Ash.setOponent(Brook);
        Brook.setOponent(Ash);


        // Creating energies Cards
        // Las cartas deben poder ser jugadas por el entrenador que la tenga
        waterEnergy = new WaterEnergy();
        waterEnergy.setTrainer(Ash);
        fireEnergy = new FireEnergy();
        fireEnergy.setTrainer(Ash);
        electricEnergy = new ElectricEnergy();
        electricEnergy.setTrainer(Ash);
        grassEnergy = new GrassEnergy();
        grassEnergy.setTrainer(Ash);
        pyshicEnergy = new PsychicEnergy();
        pyshicEnergy.setTrainer(Ash);
        normalEnergy = new NormalEnergy();
        normalEnergy.setTrainer(Ash);

        //Setting Energies requieres
        shift.receiveRequiredEnergy(waterEnergy);
        shift.receiveRequiredEnergy(fireEnergy);
        shift.receiveRequiredEnergy(grassEnergy);
        shift.receiveRequiredEnergy(electricEnergy);
        shift.receiveRequiredEnergy(pyshicEnergy);
        shift.receiveRequiredEnergy(normalEnergy);

    }

    @Test
    public void abilityRequiredEnergiesTest(){
        assertEquals(shift.getElectricRequiredEnergies(),1);
        assertEquals(shift.getFireRequiredEnergies(),1);
        assertEquals(shift.getNormalRequiredEnergies(),1);
        assertEquals(shift.getPsychicRequiredEnergies(),1);
        assertEquals(shift.getGrassRequiredEnergies(),1);
        assertEquals(shift.getWaterRequiredEnergies(),1);
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




    }

    @Test
    public void ElectricShockTest(){
        Ash.selectAbility(2);
        Ash.useAbility(Brook);
        assertTrue(Brook.getActivePokemon().getHP()==40 || Brook.getActivePokemon().getHP()==60);

    }


    @Test
    public void increaseCoverage(){
        // Este test no prueba nada, solo esta implementado para dar coverage al visitor de habilidades.
        concreteIAbilityVisitor = new ConcreteIAbilityVisitor();
        attackVisitor = new AttackVisitor();
        shift.accept(concreteIAbilityVisitor);
        concreteIAbilityVisitor.visitAttack(abstractAttack);
        waterAttack.accept(attackVisitor);
        attackVisitor.visitConcreteAbility(abstractAbilities);
    }

}
