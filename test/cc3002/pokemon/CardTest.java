package cc3002.pokemon;
import static org.junit.Assert.*;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.AfterimageAssault;
import cc3002.pokemon.Abilities.otherAbilities.Shift;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.ObjectsCards.GreatBall;
import cc3002.pokemon.TrainerCards.ObjectsCards.ObjectsCard;
import cc3002.pokemon.TrainerCards.StadiumCards.LuckyStadium;
import cc3002.pokemon.TrainerCards.StadiumCards.StaduimCard;
import cc3002.pokemon.TrainerCards.SupportCards.ProfessorCozmosDiscovery;
import cc3002.pokemon.TrainerCards.SupportCards.SupportCard;
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
    private StaduimCard stadium;
    private ObjectsCard objectsCard;
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
        stadium = new LuckyStadium("Lucky Stadium","Si juego en casa, tengo ventaja jeje xd");
        objectsCard = new GreatBall("Great Ball","Cacha como crece mi banca de pokemones jajaja.");
        Ash = new Trainer("Ash",charmander,new ArrayList<>());
    }

    @Test
    public void testingSupportCards(){
        // Mazo de charmanders
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsHand(support);
        assertEquals(Ash.sizePokeHand(),1);
        Ash.play(support);
        assertTrue(Ash.sizePokeHand()==2 || Ash.sizePokeHand()==3);
        assertFalse(Ash.getHand().contains(support));
    }

    @Test
    public void testingStadiumCards(){
        Ash.addToCardsDeck(charmander);
        Ash.dropHand();
        Ash.addToCardsHand(stadium);
        Ash.play(stadium);
        assertTrue(Ash.sizePokeHand()==1 || Ash.sizePokeHand()==2);
    }

    @Test
    public void testingObjectsCards(){
        Ash.addToCardsDeck(charmander);
        Ash.dropHand();
        Ash.addToCardsHand(objectsCard);
        Ash.setSelectedPokemon(charmander);
        Ash.play(objectsCard);
        assertTrue(Ash.sizePokeBench()==1);
    }
}
