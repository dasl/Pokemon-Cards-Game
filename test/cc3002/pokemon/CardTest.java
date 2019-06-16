package cc3002.pokemon;
import static org.junit.Assert.*;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AfterimageAssault;
import cc3002.pokemon.Abilities.otherAbilities.Shift;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.ProfessorCozmosDiscovery;
import cc3002.pokemon.TrainerCards.SupportCard;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.water.WaterAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CardTest {
    private IPokemon charmander;
    private SupportCard support;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, shift,waterAttack,afterimageassault;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;

    @Before
    public void setUp() {
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        afterimageassault = new AfterimageAssault("AfterimageAssault", 40,"An attack that may inflict a burn.",new EnergyCounter());
        shift = new Shift("Shift","Soy entero pulento",new EnergyCounter());

        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(shift,fireAttack,afterimageassault)));
        support = new ProfessorCozmosDiscovery("Professor Cozmo's Discovery","Juegos de azar y mujerzuelas");
        Ash = new Trainer("Ash",charmander,new ArrayList<>());
    }

    @Test
    public void testingCards(){
        // Mazo de charmanders
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        assertEquals(Ash.getHand().size(),0);
        Ash.play(support);
        assertTrue(Ash.getHand().size()==2 || Ash.getHand().size()==3);
    }
}
